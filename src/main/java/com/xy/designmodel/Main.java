package com.xy.designmodel;

import com.xy.designmodel.adpater.IUserInfo;
import com.xy.designmodel.adpater.OuterUserInfo;

/**
 * @author: xiaoyin
 * @date: 2021/12/27 16:36
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        IUserInfo outerUserInfo=new OuterUserInfo();
        outerUserInfo.getHomeAddress();
        outerUserInfo.getUserName();
    }
}
