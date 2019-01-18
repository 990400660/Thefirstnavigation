package com.example.pc.thefirstnavigation.base.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.example.pc.thefirstnavigation.R;
import com.example.pc.thefirstnavigation.base.presenter.BasePresenter;
import com.example.pc.thefirstnavigation.base.view.BaseView;

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends SimpleFragment implements BaseView {


    public P presenter;


    @Override
    public void viewCread(View view) {
        super.viewCread(view);
        if (presenter == null) {
            presenter = createPresenter();
            if (presenter != null) {
                presenter.boundView((V) this);
            }
        }
    }

    @Override
    public void lode() {
        if (presenter == null) {
            presenter = createPresenter();
            presenter.boundView((V) this);
        }

    }

    @Override
    public void showAnimation() {

    }

    @Override
    public void hideAnimation() {

    }


    protected abstract P createPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.unbindView();
            presenter = null;
        }
    }
}
