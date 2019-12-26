package com.example.fm.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.example.fm.R;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;


/**
 * 导航栏的适配器
 */
public class IndicatorAdapter extends CommonNavigatorAdapter {

    private String[] arrays;
    private IindicatorClickListener listener;

    public IndicatorAdapter(Context context){
        arrays = context.getResources().getStringArray(R.array.indicator_title);
    }


    @Override
    public int getCount() {
        if(arrays != null){
            return arrays.length;
        }
        return 0;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        ColorTransitionPagerTitleView pagerTitleView = new ColorTransitionPagerTitleView(context);
//        设置平常色
        pagerTitleView.setNormalColor(Color.parseColor("#aaffffff"));
//        设置选中颜色
        pagerTitleView.setSelectedColor(Color.parseColor("#ffffff"));
//        设置文字
        pagerTitleView.setText(arrays[index]);
        pagerTitleView.setTextSize(20);
        pagerTitleView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //点击滑动
                if(listener != null){
                    listener.onTabClick(index);
                }
            }
        });

        return pagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
        linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
        linePagerIndicator.setColors(Color.parseColor("#ffffff"));
        return linePagerIndicator;
    }

    /**
     * 创建监听方法，监听导航栏点击事件
     */
    public void setIndicatorClickListener(IindicatorClickListener listener){
        this.listener = listener;
    }

    /**
     * 自定义一个监听接口和方法
     */
    public interface IindicatorClickListener{
        void onTabClick(int index);
    }

}
