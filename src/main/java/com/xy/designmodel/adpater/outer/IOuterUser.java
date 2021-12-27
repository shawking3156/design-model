package com.xy.designmodel.adpater.outer;

import java.util.Map;

/**
 * @author: xiaoyin
 * @date: 2021/12/27 16:19
 * @description:
 */
public interface IOuterUser {

    //基本信息，比如名称、性别、手机号码等
    Map getUserBaseInfo();
    //工作区域信息
    Map getUserOfficeInfo();
    //用户的家庭信息
    Map getUserHomeInfo();
}
