package com.example.fm.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fm.R;
import com.example.fm.base.BaseFragment;

/**
 * 历史栏目碎片
 */
public class HistoryFragment extends BaseFragment {


    @Override
    protected View onSubViewLoaded(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_history,container,false);
        return view;
    }
}
