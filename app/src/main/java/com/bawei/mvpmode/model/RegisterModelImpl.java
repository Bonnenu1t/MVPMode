package com.bawei.mvpmode.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Bonnenu1t丶 on 2017/6/13.
 */

public class RegisterModelImpl implements IRegisterModel{


    @Override
    public void register(String phone, String pwssword, final RegisterListener listener) {

        String url="http://qhb.2dyt.com/Bwei/register?phone="+phone+"&pwssword="+pwssword+"&postkey=1503d";

        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String result=response.body().string();
                listener.onSuccess(result);
            }
        });

    }



    public interface RegisterListener{
        void onSuccess(String result);
        void onFailed();
    }
}
