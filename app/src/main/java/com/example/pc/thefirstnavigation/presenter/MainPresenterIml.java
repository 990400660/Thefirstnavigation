package com.example.pc.thefirstnavigation.presenter;

import com.example.pc.thefirstnavigation.base.presenter.BasePresenter;
import com.example.pc.thefirstnavigation.base.presenter.BasePresenterIml;
import com.example.pc.thefirstnavigation.beans.News_Channel;
import com.example.pc.thefirstnavigation.contact.ListNewTab;
import com.example.pc.thefirstnavigation.module.MainModuleIml;

public class MainPresenterIml<V extends ListNewTab.ListNewTabView> extends BasePresenterIml<V> implements ListNewTab.LisNewTabPresenter, ListNewTab.LisNewTabModule {
    private MainModuleIml mMainModuleImls = new MainModuleIml();

    @Override
    public void getListNewTab(News_Channel news_channel) {
        if (mView != null) {
            mView.hideAnimation();
            mView.showListNewTab(news_channel);
        }
    }

    @Override
    public void setShowAnimation() {

        if (mView != null) {
            mView.showAnimation();
        }

    }

    @Override
    public void setHideAnimation() {
        if (mView != null) {
            mView.hideAnimation();
        }
    }

    @Override
    public void setShowError(String error) {
        if (mView != null) {
            mView.hideAnimation();
            mView.showError(error);
        }
    }

    @Override
    public void getListNewTab(String json) {
        if (mView != null) {
            mView.showAnimation();
            mMainModuleImls.getListNewTab(json, this);
        }
    }
}
