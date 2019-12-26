package com.example.fm.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 一个基本的碎片抽象类，其他碎片类继承此类
 */
public abstract class BaseFragment extends Fragment {

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = onSubViewLoaded(inflater,container);
        return mRootView;
    }

    protected abstract View onSubViewLoaded(LayoutInflater inflater,ViewGroup container);
}
