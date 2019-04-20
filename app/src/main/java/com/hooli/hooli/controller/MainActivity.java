package com.hooli.hooli.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gongwen.marqueen.SimpleMF;
import com.gongwen.marqueen.SimpleMarqueeView;
import com.hooli.hooli.R;
import com.hooli.hooli.javabean.Dormitory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn_startGiveFen;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<String> houses = new ArrayList<>();
    private ArrayList<String> houseId = new ArrayList<>();
    private NavigationView navigationView;
    private TextView jia;
    private View view1, view2;
    private ViewPager viewPager;  //对应的viewPager
    private BottomNavigationView bottomNavigationView;//低栏
    private List<View> viewList;//view数组
    //-------------------------以上是张龙龙需要的变量--------------------------

    public void getDate() {//
        //导入宿舍信息
        houses.add("雪松苑");
        houses.add("不知道什么苑");
        houses.add("不知道什么苑");
//'''''''''''''''''''''''''''''
        houseId.add("A1");
        houseId.add("A2");
        houseId.add("A3");
        houseId.add("A4");
        houseId.add("B1");

    }

//    private void getCardData() {
//        for (int i = 0; i < 5; i++) {
//            cardItem.add(new CardBean(i, "No.ABC12345 " + i));
//        }
//
//        for (int i = 0; i < cardItem.size(); i++) {
//            if (cardItem.get(i).getCardNo().length() > 6) {
//                String str_item = cardItem.get(i).getCardNo().substring(0, 6) + "...";
//                cardItem.get(i).setCardNo(str_item);
//            }
//        }
//    }

//    private void getOptionData() {
//
//        /**
//         * SPICA善意的注释：如果是添加JavaBean实体数据，则实体类需要实现 IPickerViewData 接口，
//         * PickerView会通过getPickerViewText方法获取字符串显示出来。
//         */
//
//        getCardData();
//        getDate();
//
//        //选项1
//        options1Items.add(new houseBean(0, "雪松苑", "描述", "其他数据"));
//        options1Items.add(new houseBean(1, "其他苑", "描述部分", "其他数据"));
//        options1Items.add(new houseBean(2, "其他院", "描述部分", "其他数据"));
//
//        //选项2
//        ArrayList<String> options2Items_01 = new ArrayList<>();
//        options2Items_01.add("A1");
//        options2Items_01.add("A2");
//        options2Items_01.add("A3");
//        options2Items_01.add("A4");
//        ArrayList<String> options2Items_02 = new ArrayList<>();
//        options2Items_02.add("A1");
//        options2Items_02.add("A2");
//        options2Items_02.add("A3");
//        options2Items_02.add("A4");
//        ArrayList<String> options2Items_03 = new ArrayList<>();
//        options2Items_03.add("B1");
//        options2Items_03.add("B1");
//        options2Items.add(options2Items_01);
//        options2Items.add(options2Items_02);
//        options2Items.add(options2Items_03);
//
//        /*--------数据源添加完毕---------*/
//    }


    private void clickTabOne() {
        //为防止隔页切换时,滑过中间页面的问题,去除页面切换缓慢滑动的动画效果
        viewPager.setCurrentItem(0, false);
    }

    private void clickTabTwo() {
        viewPager.setCurrentItem(1, false);

    }

    private void clickTabThree() {
        viewPager.setCurrentItem(2, false);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //导入
        btn_startGiveFen = findViewById(R.id.btn_startGivefen);
        setContentView(R.layout.main_activity);
//        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        navigationView = findViewById(R.id.navigation_view);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        LayoutInflater inflater = getLayoutInflater();
        bottomNavigationView = findViewById(R.id.navigation);
        //view1 = inflater.inflate(R.layout.givefen_start, null);
        view2 = inflater.inflate(R.layout.fragment_give_fen, null);
        //---------------------------------------------------------------
        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
       // viewList.add(null);
        viewList.add(view2);
        //打分跳转(空指针异常)
//        btn_startGiveFen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        //分页的adapter
        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));
                return viewList.get(position);
            }
        };


        viewPager.setAdapter(pagerAdapter);
        //viewpapaer的监听器
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                //ViewPager和BottomNaviationView联动,当ViewPager的某个页面被选中了,同时设置BottomNaviationView对应的tab按钮被选中
                switch (i) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_search);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_giveFen);
                        break;
                    case 2:
//                    bottomNavigationView.setSelectedItemId(R.id.tab_three);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });


        //--------------------------------------


        //低栏监听器
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //BottomNaviationView和ViewPager联动,当BottomNaviationView的某个tab按钮被选中了,同时设置ViewPager对应的页面被选中
                int itemId = menuItem.getItemId();
                switch (itemId) {
                    case R.id.bottom_search://点击低栏搜索
                        clickTabOne();
                        return true;//返回true,否则tab按钮不变色,未被选中
                    case R.id.bottom_more://点击低栏更多
                        clickTabTwo();
                        return true;
                    case R.id.bottom_giveFen://点击低栏打分
                        clickTabThree();
                        return true;
                    case R.id.bottom_setting://点击低栏设置
                        clickTabThree();
                        return true;
                    default:
                        break;
                }
                return true;
            }
        });


//动态填充跑马灯数据
        final List<String> datas = Arrays.asList("《307张龙龙喜结良缘", "陈科宇喜获“吉祥物”称号", "震惊！赵乾惊现pronhub", "刘通爱上往兰岚", "面对疾风吧。");
//SimpleMarqueeView<T>，SimpleMF<T>：泛型T指定其填充的数据类型，比如String，Spanned等
        SimpleMarqueeView<String> marqueeView = (SimpleMarqueeView) findViewById(R.id.simpleMarqueeView);
        SimpleMF<String> marqueeFactory = new SimpleMF(this);
        marqueeFactory.setData(datas);
        marqueeView.setMarqueeFactory(marqueeFactory);
        marqueeView.startFlipping();
        //。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
//fragment1
//        FragmentTransaction replace = getFragmentManager().beginTransaction().replace(R.id.fragment_main, fragment1);


        FragmentManager fragmentManager = getSupportFragmentManager();

        //setSupportActionBar(toolbar); //引入ToolBar
//        toolbar.setTitle("标题");
//        toolbar.setSubtitle("子标题");
//        // 显示导航
//        toolbar.setNavigationIcon(R.drawable.more);
//        setSupportActionBar(toolbar);
//        // 显示应用的Logo
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.user_women);
//        // 显示标题和子标题
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    /**
     * 用来传递页面参数
     * @return
     */
    public Dormitory getDormhuash4houtai(){
   return null;
    }
}
