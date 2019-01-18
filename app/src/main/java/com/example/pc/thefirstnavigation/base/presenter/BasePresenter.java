package com.example.pc.thefirstnavigation.base.presenter;

import android.view.View;

public interface BasePresenter<V> {
    //绑定View
    void boundView(V view);
    //解绑View
    void unbindView();
}
