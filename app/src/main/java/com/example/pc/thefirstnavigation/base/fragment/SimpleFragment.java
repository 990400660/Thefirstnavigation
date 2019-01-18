package com.example.pc.thefirstnavigation.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract  class SimpleFragment extends Fragment {
    public Context mContexts;
    public Activity mActivitys;
    private Unbinder mUnbinders;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivitys = (Activity) context;
        this.mContexts = context;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinders = ButterKnife.bind(this, view);
        initData();
    }

    protected abstract void initData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        viewCread(inflate);
        return inflate;

    }
    public void viewCread(View view) {

    }
    protected abstract int getLayoutId();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            lode();
        }
    }

    public void lode() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinders != null) {
            mUnbinders.unbind();
        }
    }
}
