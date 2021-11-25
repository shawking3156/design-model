package com.xy.designmodel.proxy;

/**
 * @author: xiaoyin
 * @date: 2021/11/17 16:17
 * @description:
 */
public class TrainStation implements TicketPlatform{

    @Override
    public void saleTicket() {
        System.out.println("卖票。。");
    }

    @Override
    public void cancelTicket() {
        System.out.println("退票。。");
    }
}
