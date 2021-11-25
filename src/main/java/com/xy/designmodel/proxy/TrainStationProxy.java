package com.xy.designmodel.proxy;

/**
 * @author: xiaoyin
 * @date: 2021/11/17 16:18
 * @description:
 */
public class TrainStationProxy implements TicketPlatform{

    private TrainStation trainStation;

    public TrainStationProxy(TrainStation station){
        this.trainStation=station;
    }

    @Override
    public void saleTicket() {
        System.out.println("代理平台");
        trainStation.saleTicket();
    }

    @Override
    public void cancelTicket() {
        System.out.println("代理平台");
        trainStation.cancelTicket();
    }
}
