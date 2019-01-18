package com.example.pc.thefirstnavigation.contact;

import com.example.pc.thefirstnavigation.base.module.BaseModuleFinish;
import com.example.pc.thefirstnavigation.base.view.BaseView;
import com.example.pc.thefirstnavigation.beans.News_Channel;

public interface ListNewTab {

    public interface ListNewTabView extends BaseView {
        void showListNewTab(News_Channel news_channel);

    }

    interface LisNewTabPresenter{
        void getListNewTab(String json);
    }


    public interface LisNewTabModule extends BaseModuleFinish{
        void getListNewTab(News_Channel news_channel);
    }
}
