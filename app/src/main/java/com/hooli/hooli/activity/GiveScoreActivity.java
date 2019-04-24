package com.hooli.hooli.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hooli.hooli.R;
import com.hooli.hooli.javabean.DayRecord4Transition;
import com.hooli.hooli.javabean.Dormitory4Transition;
import com.suke.widget.SwitchButton;
import com.tapadoo.alerter.Alerter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class GiveScoreActivity extends AppCompatActivity implements SwitchButton.OnCheckedChangeListener{

    @BindView(R.id.btn_save)
    Button btn_save;
    @BindView(R.id.ischeck_balcony)
    SwitchButton ischeck_balcory;
    @BindView(R.id.ischeck_wc)
    SwitchButton ischeck_wc;
    @BindView(R.id.ischeck_safe)
    SwitchButton ischeck_safe;
    @BindView(R.id.ischeck_groundcheck)
    SwitchButton ischeck_window;

    TextView tvShowData;
    TextView tvBalcony;
    TextView tvGround;
    TextView tvWc;
    TextView tvSafe;

    Dormitory4Transition dormitory;
    DayRecord4Transition dayRecord4Transition = new DayRecord4Transition();
//-------获取布局元素------

    Boolean $issafe;//违规电器
    Boolean $isbalcony;//阳台
    Boolean $iswc;//厕所
    Boolean $isground;//地面

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
        return $isground;
    }



    @OnClick(R.id.btn_save)
    void onClick(View view) {
        if ($isbalcony && $issafe && $iswc && $isground) {
            Toast.makeText(GiveScoreActivity.this, "合格", Toast.LENGTH_SHORT);
            finish();
        } else {
            AlertDialog.Builder normalDialog =
                    new AlertDialog.Builder(GiveScoreActivity.this);
            normalDialog.setIcon(R.drawable.icon);
            normalDialog.setTitle("通知").setMessage("是否拍照");
            normalDialog.setPositiveButton("是",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Todo
                            finish();
                        }
                    });
            normalDialog.setNeutralButton("不要",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Todo
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

        showIntent();


    }

    //传出数据
    void showIntent() {
        tvBalcony = findViewById(R.id.tv_balcony);
        tvGround  = findViewById(R.id.tv_ground);
        tvWc = findViewById(R.id.tv_wc);
        tvSafe = findViewById(R.id.tv_safe);

        dayRecord4Transition.setBalcony($isbalcony);
        dayRecord4Transition.setWc($iswc);
        dayRecord4Transition.setGround($isground);
        dayRecord4Transition.setIllegalAppliances($issafe);

        Intent intent = new Intent();
        intent.putExtra("checkedData",dormitory);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_score);
        tvShowData = findViewById(R.id.tv_show_data);

        //接受数据  动态显示
        dormitory = (Dormitory4Transition) getIntent().getSerializableExtra("buildData");
        String showText = dormitory.getBuilding()+" "+dormitory.getBuildingNum()+" "+dormitory.getDormitoryNum();
        tvShowData.setText(showText);



        ButterKnife.bind(this);
        btn_save = findViewById(R.id.btn_save);
        ischeck_balcory = findViewById(R.id.ischeck_balcony);
        ischeck_safe = findViewById(R.id.ischeck_safe);
        ischeck_wc = findViewById(R.id.ischeck_wc);
        ischeck_window = findViewById(R.id.ischeck_groundcheck);

        $issafe = ischeck_safe.isChecked();//违规电器
        $isbalcony = ischeck_balcory.isChecked();//阳台
        $iswc = ischeck_wc.isChecked();//厕所
        $isground = ischeck_window.isChecked();//地面

        ischeck_window.setOnCheckedChangeListener(this);
        ischeck_wc.setOnCheckedChangeListener(this);
        ischeck_safe.setOnCheckedChangeListener(this);
        ischeck_balcory.setOnCheckedChangeListener(this);


    }



    @Override
    public void onCheckedChanged(SwitchButton view, boolean isChecked) {
        $issafe = ischeck_safe.isChecked();//
        $isbalcony = ischeck_balcory.isChecked();//
        $iswc = ischeck_wc.isChecked();//
        $isground = ischeck_window.isChecked();//
        if (!$isground || !$iswc || !$issafe || !$isbalcony) {
            Toast.makeText(GiveScoreActivity.this, "不合格", Toast.LENGTH_SHORT).show();
        }
    }
}
