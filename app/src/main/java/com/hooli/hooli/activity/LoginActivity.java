package com.hooli.hooli.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.hooli.hooli.R;
import com.hooli.hooli.R2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity {
    @BindView(R2.id.bt_loginIn)
    Button bt_loginIn;
    @BindView(R2.id.et_name)
    EditText et_name;
    @BindView(R2.id.et_password)
    EditText et_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }
    @OnClick({R2.id.bt_loginIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_loginIn:
                String acount = et_name.getText().toString();
                String password = et_password.getText().toString();
                if (acount == null || "".equals(acount)) {
                    Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (password == null || "".equals(password)) {
                    Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if ("hooli".equals(acount) && "111".equals(password)) {
                    //TODO:跳转
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {

                    Snackbar.make(view, "账号或者密码错误，忘记密码？", Snackbar.LENGTH_SHORT)
                            .setAction("找回密码", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(LoginActivity.this, "这个也没有开发呢，别急，亲", Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                }
                // TODO:后台校验用户名和密码
                break;


        }
    }
}
