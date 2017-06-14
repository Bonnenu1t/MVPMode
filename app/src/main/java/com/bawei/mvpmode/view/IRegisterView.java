package com.bawei.mvpmode.view;

/**
 * Created by Bonnenu1t丶 on 2017/6/13.
 */

public interface IRegisterView {

    //手机号为空
    public void phoneEnpty();

    //密码为空
    public void passwordEnpty();

    //注册成功
    public void registerSuccess(String result);

    //注册失败
    public void registerFailed();
}
