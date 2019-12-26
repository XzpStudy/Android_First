package com.example.fm.utils;


import com.example.fm.base.BaseFragment;
import com.example.fm.fragment.HistoryFragment;
import com.example.fm.fragment.RecommendFragment;
import com.example.fm.fragment.SubscriptionFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * 做一个碎片的缓存类
 */
public class FragmentCreator {

    private final static int INDEX_RECOMMEND = 0;
    private final static int INDEX_SUBSCRIPTION = 1;
    private final static int INDEX_HISTORY = 2;

    public final static int PAGE_COUNT = 3;

    //使用一个Map集合存储Fragment
    private static Map<Integer, BaseFragment> mapCache = new HashMap<>();


    /**
     * 该方法会将创建过的Fragment存入Map，当作缓存
     */
    public static BaseFragment getFragment(int index){
        BaseFragment baseFragment = mapCache.get(index);
        if(baseFragment != null){
            return baseFragment;
        }
        switch (index){
            case INDEX_RECOMMEND:
                baseFragment = new RecommendFragment();
                break;
            case INDEX_SUBSCRIPTION:
                baseFragment = new SubscriptionFragment();
                break;
            case INDEX_HISTORY:
                baseFragment = new HistoryFragment();
                break;
        }
        mapCache.put(index,baseFragment);
        return baseFragment;
    }
}
