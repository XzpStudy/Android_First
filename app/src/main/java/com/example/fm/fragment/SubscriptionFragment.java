package com.example.fm.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fm.R;
import com.example.fm.base.BaseFragment;

/**
 * 订阅栏目碎片
 */
public class SubscriptionFragment extends BaseFragment {

    @Override
    protected View onSubViewLoaded(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_subscription,container,false);
        return view;
    }
}
