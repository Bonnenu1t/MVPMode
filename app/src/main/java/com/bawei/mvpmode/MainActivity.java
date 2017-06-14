package com.bawei.mvpmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.mvpmode.presenter.MainActivityPresenter;
import com.bawei.mvpmode.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

// 处理view 的显示 隐藏  还有view 的常用事件
public class MainActivity extends Activity implements MainView {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btn_login)
    Button btnLogin;
    MainActivityPresenter presenter;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainActivityPresenter(this);
    }

    //登录的点击事件
    @OnClick(R.id.btn_login)
    public void onViewClicked(View view) {
        presenter.login(username.getText().toString(), password.getText().toString());
    }

    //注册的点击事件
    @OnClick(R.id.btn_register)
    public void onRegister(View view) {
        startActivity(new Intent(this,IRegisterActivity.class));
    }

    @Override
    public void usernameEnpty() {
        Toast.makeText(this, "姓名不能为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordEnpty() {
        Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSucuess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void loginFailed() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
