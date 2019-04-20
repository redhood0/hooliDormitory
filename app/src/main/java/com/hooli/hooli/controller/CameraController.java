package com.hooli.hooli.controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hooli.hooli.R;

import java.io.File;
import java.io.IOException;

public class CameraController  extends AppCompatActivity implements View.OnClickListener {
    public static final int TAKE_PHOTO = 1;
    public static final int CROP_PHOTO = 2;
    private Button btn_takephote;
    private ImageView picture;
    private Uri imageUri;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_my);

        btn_takephote = findViewById(R.id.btn_takephote);
        picture = findViewById(R.id.pic);
        btn_takephote.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        File outputImage=new File(getExternalCacheDir(),"output_image.jpg");
                /*
                创建一个File文件对象，用于存放摄像头拍下的图片，我们把这个图片命名为output_image.jpg
                并把它存放在应用关联缓存目录下，调用getExternalCacheDir()可以得到这个目录，为什么要
                用关联缓存目录呢？由于android6.0开始，读写sd卡列为了危险权限，使用的时候必须要有权限，
                应用关联目录则可以跳过这一步
                 */
        try//判断图片是否存在，存在则删除在创建，不存在则直接创建
        {
            if(outputImage.exists())
            {
                outputImage.delete();
            }
            outputImage.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

//        imageUri= FileProvider.getUriForFile(CameraController.this,
//                "com.example.cameraalbumtest.fileprovider", outputImage);
                    /*
                    第一个参数：context对象
                    第二个参数：任意唯一的字符串
                    第三个参数：文件对象
                     */


        imageUri = Uri.fromFile(outputImage);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
       // intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        //startActivityForResult(intent, TAKE_PHOTO);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
