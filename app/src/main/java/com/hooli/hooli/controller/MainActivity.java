package com.hooli.hooli.controller;


import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.google.android.material.navigation.NavigationView;
import com.hooli.hooli.R;
import com.hooli.hooli.fragment.Fragment_givefraction_choose;
import com.hooli.hooli.fragment.Fragment_homepage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private NavigationView navigationView;
    @BindView(R.id.bottomNavigationBar_main_activity)
    BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;


    //-------------------------以上是张龙龙需要的变量--------------------------


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();
        initNavigation();

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_first_fragment:
                        ft.remove(new Fragment_givefraction_choose());
                        ft.replace(R.id.fragment_main_page, new Fragment_homepage()).commit();
                        Toast.makeText(MainActivity.this, "加载主页面", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_second_fragment:
                        Toast.makeText(MainActivity.this, "加载设置页面", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_third_fragment:
                        Toast.makeText(MainActivity.this, "加载拓展页面", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_home_search:
                        Toast.makeText(MainActivity.this, "加载查询页面", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_home_ischeck:
                        Toast.makeText(MainActivity.this, "打分页面张开", Toast.LENGTH_LONG).show();
                        ft.remove(new Fragment_homepage());
                        ft.replace(R.id.fragment_main_page, new Fragment_givefraction_choose());
                        ft.commit();
                        break;
                    case R.id.nav_home_giveFraction:

                        Toast.makeText(MainActivity.this, "加载打分功能页面", Toast.LENGTH_SHORT).show();

                        break;
                }
                return true;
            }
        });


    }

    private void initNavigation() {
        //导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
        bottomNavigationBar.setMode(BottomNavigationBar. MODE_SHIFTING);
        bottomNavigationBar.setBarBackgroundColor(R.color.white);//
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            //todo---------添加选项卡切换事件监听-----------------
            @Override
            public void onTabSelected(int position) {
                fragmentManager = getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                    default:
                        break;



                }
                // 事务提交
                transaction.commit();

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        //需要添加的item数
        bottomNavigationBar
                //选中时的图片的资源、文字
                .addItem(new BottomNavigationItem(R.drawable.home, "主页"))
                .addItem(new BottomNavigationItem(R.drawable.ba, "校园吧"))
                .addItem(new BottomNavigationItem(R.drawable.more, "更多"))
                .addItem(new BottomNavigationItem(R.drawable.person, "我的"))
                .initialise();


    }


}





