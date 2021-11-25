package com.xy.designmodel.proxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: xiaoyin
 * @date: 2021/11/17 16:20
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");



        TrainStation trainStation=new TrainStation();
//        trainStation.saleTicket();
//        trainStation.cancelTicket();
//
//        /**静态代理**/
//        TrainStationProxy trainStationProxy=new TrainStationProxy(trainStation);
//        trainStationProxy.saleTicket();
//        trainStationProxy.cancelTicket();
        /**jdk动态代理**/
//        TicketPlatform ticketPlatform=(TicketPlatform)getJDKProxy(trainStation);
//        ticketPlatform.saleTicket();
//        ticketPlatform.cancelTicket();

        /*保存生成的class文件**/
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D://design-model");
        /**cglib动态代理**/
        TicketPlatform cglibProxyTicketPlatform=(TicketPlatform)getCglibProxy(trainStation);
        cglibProxyTicketPlatform.saleTicket();
        cglibProxyTicketPlatform.cancelTicket();

    }

    /**
     * JDK获取真实对象的代理实例
     * @param target
     * @return
     */
    private static Object getJDKProxy(final Object target) {
        Object proxy = Proxy.newProxyInstance(
                /*类加载器*/
                target.getClass().getClassLoader(),
                /*真实类所拥有的全部接口的数组*/
                target.getClass().getInterfaces(),
                /*映射处理器，代理对象调用方法的时候会调用这个invoke方法，
                * 参数说明：
                * proxy: 一般是指代理类,这里用的是真实方法映射没用代理类映射方法。所以没有使用
                * method:被代理的方法
                * args: 该方法的参数数组*/
                new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName() + "方法开始执行...");
                        Object result = method.invoke(target, args);
                        System.out.println(method.getName() + "方法执行结束...");
                        return result;
                    }
                }
        );
        return proxy;
    }
    /**
     * cglib获取真实对象的代理实例
     * @param target
     * @return
     */
    private static Object getCglibProxy(final Object target) {
        //Enhancer是cglib中使用频率很高的一个类，它是一个字节码增强器，
        // 可以用来为无接口的类创建代理。它的功能与java自带的Proxy类挺相似
        // 它会根据某个给定的类创建子类。
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //回调拦截器，跟jdk InvocationHandler功能类似。
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println(method.getName() + "cglib方法开始执行...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println(method.getName() + "cglib方法执行结束...");
                return result;
            }
        });
        return enhancer.create();
    }
}
