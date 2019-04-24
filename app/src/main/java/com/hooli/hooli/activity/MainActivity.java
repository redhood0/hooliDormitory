package com.hooli.hooli.activity;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.google.android.material.navigation.NavigationView;
import com.hooli.hooli.R;
import com.hooli.hooli.fragment.GiveScoreFragment;
import com.hooli.hooli.fragment.HomePageFragment;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragments;
    private FragmentTransaction transition;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction2;
    private Fragment currentFragment = new Fragment();
    private Fragment homePageFragment = new Fragment();
    private Fragment giveScoreFragment = new Fragment();
    private NavigationView navigationView;
    @BindView(R.id.bottomNavigationBar_main_activity)
    BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;

    //-------------------------以上是张龙龙需要的变量--------------------------
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //--------载入低栏------
        initNavigation();
        //----预加载碎片，避免崩溃------------
        addFragment();
        switchFragment(homePageFragment).commit();


        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_first_fragment:
                        switchFragment(homePageFragment).commit();
                        bottomNavigationBar.selectTab(0);
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

                        break;
                    case R.id.nav_home_giveFraction:

                        Toast.makeText(MainActivity.this, "加载打分功能页面", Toast.LENGTH_SHORT).show();
                        switchFragment(giveScoreFragment).commit();

                        break;
                }
                return true;
            }
        });


    }

    //------------封装一个切换碎片的方法---------------------------------
    private FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //todo----第一次使用switchFragment()时currentFragment为null，所以要判断一下
        if (!targetFragment.isAdded()) {

            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.fra_main, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction.hide(currentFragment).
                    show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }
//-------------------------------------------------------------
    //-------------封装一个载入低栏的方法-----------------------------

    private void initNavigation() {
        //导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBarBackgroundColor(R.color.white);//
        bottomNavigationBar.hide(false);
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            //todo---------添加选项卡切换事件监听-----------------
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        switchFragment(homePageFragment).commit();
                        navigationView.setSelected(false);
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
                .initialise();//末尾添加


    }

    //-----------------------------------------------------------------------------
    private void addFragment() {
        homePageFragment = new HomePageFragment();
        giveScoreFragment = new GiveScoreFragment();

    }

    /**
     * 动态显示Fragment
     *
     * @param showFragment 要增加的fragment
     * @param add          true：增加fragment；false：切换fragment
     */
    private void hideOthersFragment(Fragment showFragment, boolean add) {
        transition = fragmentManager.beginTransaction();
        if (add)
            transition.add(R.id.fra_main, showFragment);
        for (Fragment fragment : fragments) {
            if (showFragment.equals(fragment)) {
                transition.show(fragment);
            } else {
                transition.hide(fragment);
            }
        }
        transition.commit();
    }

}





