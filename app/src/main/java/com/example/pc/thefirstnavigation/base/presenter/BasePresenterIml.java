package com.example.pc.thefirstnavigation.base.presenter;

import java.lang.ref.WeakReference;

public class BasePresenterIml<V> implements BasePresenter<V> {


    //弱引用
    private WeakReference<V> weakReference;
    protected V mView;

    @Override
    public void boundView(V view) {
        weakReference = new WeakReference<V>(view);
        mView = weakReference.get();
    }

    @Override
    public void unbindView() {
        if (weakReference != null) {
            weakReference.clear();
        }
    }
}
