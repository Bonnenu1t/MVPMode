package com.bawei.mvpmode.presenter;

import android.text.TextUtils;

import com.bawei.mvpmode.model.MainActivityModelImpler;
import com.bawei.mvpmode.view.MainView;

/**
 * Created by Bonnenu1t丶 on 2017/6/13.
 * 是model和view的通信桥梁
 */

public class MainActivityPresenter implements MainActivityModelImpler.MainActivityModelListener{

    public MainView mainView;
    public MainActivityModelImpler mainActivityModelImpler;

    public MainActivityPresenter(MainView mainView){
        this.mainView = mainView;
        this.mainActivityModelImpler = new MainActivityModelImpler(this);
    }

    public void login(String username,String password){
        if (TextUtils.isEmpty(username)){
            mainView.usernameEnpty();
            return;
        }
        if (TextUtils.isEmpty(password)){
            mainView.passwordEnpty();
            return;
        }

        mainActivityModelImpler.login(username,password);
    }

    @Override
    public void onSuccess() {
        mainView.loginSucuess();
    }

    @Override
    public void onFailed() {
        mainView.loginFailed();
    }
}
