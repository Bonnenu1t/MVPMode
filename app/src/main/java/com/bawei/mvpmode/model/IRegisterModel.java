package com.bawei.mvpmode.model;

/**
 * Created by Bonnenu1t丶 on 2017/6/13.
 */

public interface IRegisterModel {
    //做方法的申明
    void register(String phone, String pwssword, RegisterModelImpl.RegisterListener listener);

}
