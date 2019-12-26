package com.example.fm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.VoiceInteractor;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.util.Log;

import com.example.fm.adapter.IndicatorAdapter;
import com.example.fm.adapter.ViewPageContentAdapter;
import com.example.fm.utils.LogUtil;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.category.Category;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private MagicIndicator magicIndicatorMain;
    private ViewPager viewPage;
    private IndicatorAdapter indicatorAdapter;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIndicator();
        initEvent();

    }

    /**
     * 导航栏点击监听事件
     */
    private void initEvent(){
        indicatorAdapter.setIndicatorClickListener(new IndicatorAdapter.IindicatorClickListener() {
            @Override
            public void onTabClick(int index) {
                if(viewPage != null) {
                    viewPage.setCurrentItem(index);
                }
            }
        });
    }

    /**
     * 初始化标题导航栏
     */
    private void initIndicator(){
//        导航栏
        magicIndicatorMain = findViewById(R.id.indicator_main);
        magicIndicatorMain.setBackgroundColor(getResources().getColor(R.color.color_main));
        indicatorAdapter = new IndicatorAdapter(this);
//        设置滑动监听
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(indicatorAdapter);
//         导航对应的ViewPage
        viewPage = findViewById(R.id.view_page_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        ViewPageContentAdapter viewPageContentAdapter = new ViewPageContentAdapter(fragmentManager);
        viewPage.setAdapter(viewPageContentAdapter);
//        设置滑动监听
        magicIndicatorMain.setNavigator(commonNavigator);
//        绑定Indicator和ViewPage
        ViewPagerHelper.bind(magicIndicatorMain,viewPage);

    }

}
