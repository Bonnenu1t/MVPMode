package com.bawei.mvpmode.presenter;

import android.text.TextUtils;

import com.bawei.mvpmode.model.RegisterModelImpl;
import com.bawei.mvpmode.view.IRegisterView;

/**
 * Created by Bonnenu1t丶 on 2017/6/13.
 */

public class RegisterPresenter{

    public IRegisterView iRegisterView;

    RegisterModelImpl registerModel;

    public RegisterPresenter(IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
        this.registerModel = new RegisterModelImpl();
    }

    public void register(String phone,String password){
        if (TextUtils.isEmpty(phone)) {
            iRegisterView.phoneEnpty();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            iRegisterView.passwordEnpty();
            return;
        }
        registerModel.register(phone, password, new RegisterModelImpl.RegisterListener() {
            @Override
            public void onSuccess(String result) {
                if (iRegisterView != null){
                    iRegisterView.registerSuccess(result);
                }
            }

            @Override
            public void onFailed() {
                if (iRegisterView != null){
                    iRegisterView.registerFailed();
                }
            }
        });


    }


}
