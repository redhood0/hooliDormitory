package com.hooli.hooli;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hooli.hooli.controller.HomePageController;
import com.hooli.hooli.controller.MainActivity;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    public EditText et_name;
    public EditText et_password;
    public Button bt_loginIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        et_name = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);
        bt_loginIn = findViewById(R.id.bt_loginIn);

        bt_loginIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String acount = et_name.getText().toString();
        String password = et_password.getText().toString();
        if(acount == null || "".equals(acount)){
            Toast.makeText(Login_Activity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login_Activity.this, MainActivity.class);
            startActivity(intent);
        } else if(password == null || "".equals(password)){
            Toast.makeText(Login_Activity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
        }else if("hooli".equals(acount)  && "111".equals(password)){
            //TODO:跳转
            Intent intent = new Intent(Login_Activity.this, MainActivity.class);
            startActivity(intent);
        }else{
            //Toast.makeText(MainActivity.this,"用户名或密码不正确",Toast.LENGTH_SHORT).show();
            Snackbar.make(v, "账号或者密码错误，忘记密码？", Snackbar.LENGTH_SHORT)
                    .setAction("找回密码", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(Login_Activity.this, "这个也没有开发呢，别急，亲", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
        }
        //TODO:后台校验用户名和密码

    }
}
