package com.bawei.mvpmode.view;

/**
 * Created by Bonnenu1t丶 on 2017/6/13.
 */

public interface MainView {

    //用户名为空
    public void usernameEnpty();

    //密码为空
    public void passwordEnpty();

    //登陆成功
    public void loginSucuess();

    //登录失败
    public void loginFailed();

}
