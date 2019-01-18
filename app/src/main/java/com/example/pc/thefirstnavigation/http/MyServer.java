package com.example.pc.thefirstnavigation.http;

import com.example.pc.thefirstnavigation.beans.BaseDemo;
import com.example.pc.thefirstnavigation.beans.News_Channel;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface MyServer {


  /*  String URL = "https://www.firstgainfo.com/firstga/app/";

    @POST
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<BaseDemo<News_Channel>>getNewsChannel(@Url String url, @Body RequestBody requestBody );*/
    String URL="https://www.firstgainfo.com/firstga/app/";
    @POST("news/listNewsChannel")
    @Headers("Content-Type:application/json")
    Observable<BaseDemo<News_Channel>>news_Channel(@Body RequestBody requestBody);

}
