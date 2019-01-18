package com.example.pc.thefirstnavigation.module;

import android.util.Log;

import com.example.pc.thefirstnavigation.beans.BaseDemo;
import com.example.pc.thefirstnavigation.beans.News_Channel;
import com.example.pc.thefirstnavigation.contact.ListNewTab;
import com.example.pc.thefirstnavigation.http.BaseObserver;
import com.example.pc.thefirstnavigation.http.HttpManager;
import com.example.pc.thefirstnavigation.utils.HttpUtils;
import com.example.pc.thefirstnavigation.utils.RxUtils;

public class MainModuleIml {

    public void getListNewTab(String json, final ListNewTab.LisNewTabModule lisNewTabModule) {

        lisNewTabModule.setShowAnimation();

        HttpManager.getInstance().getServer().news_Channel(HttpUtils.getInstance().getJsonBody(json))
                .compose(RxUtils.<BaseDemo<News_Channel>>rxScheduleThread())
                .compose(RxUtils.<News_Channel>handleResult())
                .subscribe(new BaseObserver<News_Channel>(lisNewTabModule) {
                    @Override
                    public void onNext(News_Channel value) {
                        Log.e("litao",value.toString());
                        lisNewTabModule.getListNewTab(value);
                    }
                });
    }


}
