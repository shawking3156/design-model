package com.xy.designmodel.adpater;

/**
 * @author: xiaoyin
 * @date: 2021/12/27 16:07
 * @description:
 */
public class UserInfo implements IUserInfo{

    @Override
    public String getUserName() {
        return "userName";
    }

    @Override
    public String getHomeAddress() {
        return "homeAddress";
    }

    @Override
    public String getMobileNumber() {
        return "mobile";
    }

    @Override
    public String getOfficeTelNumber() {
        return "telNumber";
    }

    @Override
    public String getJobPosition() {
        return "jobPosition";
    }
}
