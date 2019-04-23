package com.hooli.hooli.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hooli.hooli.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;


public class HomePageFragment extends Fragment {

    View myZhuYeView;
    List<Integer> ImageUrlData;
    List<String> ContentData;
    @BindView(R.id.banner)
    Banner myBanner;
    private ArrayList<Integer> imagePath;
    private ArrayList<String> imageTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, null);
        myBanner = view.findViewById(R.id.banner);
        myZhuYeView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_homepage, container, false);

        initBanner();
        return view;
    }

    //封装加载图片方法
    private void initBanner() {
        ImageUrlData = new ArrayList<>();
        ContentData = new ArrayList<>();
        //todo----------载入图片--------------
        ImageUrlData.add(R.drawable.icon);
        ImageUrlData.add(R.drawable.icon);
        ImageUrlData.add(R.drawable.icon);
        ImageUrlData.add(R.drawable.icon);
        //todo----设置图片介绍--------------
        ContentData.add("1");
        ContentData.add("2");
        ContentData.add("3");
        ContentData.add("4");
        myBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        myBanner.setImageLoader(new MyLoader());
        myBanner.setImages(ImageUrlData);
        myBanner.setBannerTitles(ContentData);
        myBanner.setBannerAnimation(Transformer.Default);
        //切换频率
        myBanner.setDelayTime(3000);
        //自动启动
        myBanner.isAutoPlay(true);
        //位置设置
        myBanner.setIndicatorGravity(BannerConfig.CENTER);
        //开始运行
        myBanner.start();

    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //Glide设置图片的简单用法
            Glide.with(getActivity()).load(path).into(imageView);

        }

    }

}
