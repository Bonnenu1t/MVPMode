package com.bawei.mvpmode.model;

/**
 * Created by Bonnenu1t丶 on 2017/6/13.
 */

public interface IMainActivityModel {

    //做方法的申明

    //登录
    public void login(String username,String password);

    //忘记密码
    public void forget(String phone);
}
