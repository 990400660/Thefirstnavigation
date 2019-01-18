package com.example.pc.thefirstnavigation.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.pc.thefirstnavigation.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class SimpleActivity extends AppCompatActivity {

    private Unbinder bind;
    private Activity mActivitys;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建视图
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate(createLayoutId(), null);
        //设置关联视图
        setContentView(viewGroup);
        //找控件
        bind = ButterKnife.bind(this, viewGroup);
        mActivitys = this;

        viewCreated(viewGroup);
        //写代码
        initData();
    }


    //Toolbar绑定关联
    protected void setToolBar(final Toolbar toolbar, String title, int num) {
        if (num == 1) {
            toolbar.setTitle(title);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        } else {
            toolbar.setTitle(title);
            setSupportActionBar(toolbar);
            /* getSupportActionBar().*/
            toolbar.setNavigationIcon(R.drawable.close);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }

    }

    public void viewCreated(View view) {

    }

    //创建视图
    protected abstract int createLayoutId();

    //逻辑代码
    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }
}
