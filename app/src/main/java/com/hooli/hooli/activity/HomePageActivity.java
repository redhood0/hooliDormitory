package com.hooli.hooli.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hooli.hooli.R;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btn_camera;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_my);

        btn_camera = findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(HomePageActivity.this, CameraActivity.class);
        startActivity(intent);
    }
}
