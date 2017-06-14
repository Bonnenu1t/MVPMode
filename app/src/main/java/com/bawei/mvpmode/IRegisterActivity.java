package com.bawei.mvpmode;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.mvpmode.presenter.RegisterPresenter;
import com.bawei.mvpmode.view.IRegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Bonnenu1t丶 on 2017/6/13.
 */

public class IRegisterActivity extends Activity implements IRegisterView {
    @BindView(R.id.register_user)
    EditText registerUser;
    @BindView(R.id.register_pws)
    EditText registerPws;
    @BindView(R.id.register_btn)
    Button registerBtn;
    private RegisterPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);
        ButterKnife.bind(this);

        presenter = new RegisterPresenter(this);
    }

    @OnClick(R.id.register_btn)
    public void onViewClicked() {
        presenter.register(registerUser.getText().toString().trim(),registerPws.getText().toString().trim());
    }

    @Override
    public void phoneEnpty() {

    }

    @Override
    public void passwordEnpty() {

    }

    @Override
    public void registerSuccess(String result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(IRegisterActivity.this, "register success", Toast.LENGTH_SHORT).show();
            }
        });
        finish();
    }

    @Override
    public void registerFailed() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(IRegisterActivity.this, "register failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.iRegisterView = null;
        presenter = null ;
    }
}
