package com.hooli.hooli.controller;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hooli.hooli.R;
import com.suke.widget.SwitchButton;
import com.tapadoo.alerter.Alerter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;


public class Givefen_check extends AppCompatActivity {

    @BindView(R.id.btn_save)
    Button btn_save;
    @BindView(R.id.ischeck_balcony)
    SwitchButton ischeck_balcory;
    @BindView(R.id.ischeck_wc)
    SwitchButton ischeck_wc;
    @BindView(R.id.ischeck_safe)
    SwitchButton ischeck_safe;
    @BindView(R.id.ischeck_windowscheck)
    SwitchButton ischeck_window;
//-------获取布局元素------

    Boolean $issafe;//违规电器
    Boolean $isbalcony;//阳台
    Boolean $iswc;//厕所
    Boolean $iswindow;//窗户

    public Boolean get$isbalcony() {
        return $isbalcony;
    }

    public Boolean get$issafe() {
        return $issafe;
    }

    public Boolean get$iswc() {
        return $iswc;
    }

    public Boolean get$iswindow() {
        return $iswindow;
    }
public
//    @OnCheckedChanged({R.id.ischeck_windowscheck, R.id.ischeck_safe, R.id.ischeck_wc, R.id.ischeck_balcony})
//    void showToast() {
//        //更新数据
//        $issafe = ischeck_safe.isChecked();//
//        $isbalcony = ischeck_balcory.isChecked();//
//        $iswc = ischeck_wc.isChecked();//
//        $iswindow = ischeck_window.isChecked();//
//        if ($iswindow && $iswc && $issafe && $isbalcony) {
//            Toast.makeText(Givefen_check.this, "合格", Toast.LENGTH_LONG).show();
//        }
//    }



    @OnClick(R.id.btn_save)
  void onClick(View view) {
        if ($isbalcony && $issafe && $iswc && $iswindow) {
            Toast.makeText(Givefen_check.this, "合格", Toast.LENGTH_LONG);
            finish();
        } else {
            AlertDialog.Builder normalDialog =
                    new AlertDialog.Builder(Givefen_check.this);
            normalDialog.setIcon(R.drawable.icon);
            normalDialog.setTitle("通知").setMessage("是否拍照");
            normalDialog.setPositiveButton("是",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // ...To-do
                            finish();
                        }
                    });
            normalDialog.setNeutralButton("不要",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // ...To-do
                            finish();
                        }
                    });

            // 创建实例并显示
            normalDialog.show();
            //----------
            Alerter.create(this)
                    .setText("保存...")
                    .setIcon(R.drawable.icon)
                    .setIconColorFilter(0) //
                    .show();

        }


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.givefraction_check);
        ButterKnife.bind(this);
        btn_save = findViewById(R.id.btn_save);
        ischeck_balcory = findViewById(R.id.ischeck_balcony);
        ischeck_safe = findViewById(R.id.ischeck_safe);
        ischeck_wc = findViewById(R.id.ischeck_wc);
        ischeck_window = findViewById(R.id.ischeck_windowscheck);
        //--------------
        $issafe = ischeck_safe.isChecked();//违规电器
        $isbalcony = ischeck_balcory.isChecked();//阳台
        $iswc = ischeck_wc.isChecked();//厕所
        $iswindow = ischeck_window.isChecked();//窗户
        ischeck_window.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                     //更新数据
        $issafe = ischeck_safe.isChecked();//
        $isbalcony = ischeck_balcory.isChecked();//
        $iswc = ischeck_wc.isChecked();//
        $iswindow = ischeck_window.isChecked();//
        if ($iswindow && $iswc && $issafe && $isbalcony) {
            Toast.makeText(Givefen_check.this, "合格", Toast.LENGTH_LONG).show();
        }

            }
        });
        ischeck_wc.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                $issafe = ischeck_safe.isChecked();//
                $isbalcony = ischeck_balcory.isChecked();//
                $iswc = ischeck_wc.isChecked();//
                $iswindow = ischeck_window.isChecked();//
                if ($iswindow && $iswc && $issafe && $isbalcony) {
                    Toast.makeText(Givefen_check.this, "合格", Toast.LENGTH_LONG).show();
                }

            }
        });
ischeck_safe.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(SwitchButton view, boolean isChecked) {
        $issafe = ischeck_safe.isChecked();//
        $isbalcony = ischeck_balcory.isChecked();//
        $iswc = ischeck_wc.isChecked();//
        $iswindow = ischeck_window.isChecked();//
        if ($iswindow && $iswc && $issafe && $isbalcony) {
            Toast.makeText(Givefen_check.this, "合格", Toast.LENGTH_LONG).show();
        }

    }
});
ischeck_balcory.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(SwitchButton view, boolean isChecked) {
        $issafe = ischeck_safe.isChecked();//
        $isbalcony = ischeck_balcory.isChecked();//
        $iswc = ischeck_wc.isChecked();//
        $iswindow = ischeck_window.isChecked();//
        if ($iswindow && $iswc && $issafe && $isbalcony) {
            Toast.makeText(Givefen_check.this, "合格", Toast.LENGTH_LONG).show();
        }

    }
});

    }
}
