package com.bawei.mvpmode.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Bonnenu1t丶 on 2017/6/13.
 * 网络请求 本地数据库  业务逻辑操作
 */

public class MainActivityModelImpler implements IMainActivityModel{

    public MainActivityModelListener listener;

    public MainActivityModelImpler(MainActivityModelListener listener){
        this.listener= listener;
    }

    public static String url="http://qhb.2dyt.com/Bwei/login";

    @Override
    public void login(String username, String password) {

        StringBuilder builder=new StringBuilder();
        builder.append(url).append("?username=")
                .append(username).append("&password=")
                .append(password).append("&postkey=1503d");

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(builder.toString()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //失败的回调
                listener.onFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //成功的回调
                String result = response.body().string();

                listener.onSuccess();

            }
        });

    }

    @Override
    public void forget(String phone) {

    }

    public interface MainActivityModelListener {

        public void onSuccess();

        public void onFailed();
    }
}
