package com.example.pc.thefirstnavigation.utils;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class HttpUtils {
    private static HttpUtils apiManager;

    private HttpUtils(){

    }

    public static HttpUtils getInstance(){
        if (apiManager == null) {
            synchronized (HttpUtils.class){
                if (apiManager == null) {
                    apiManager=new HttpUtils();
                }
            }
        }

        return apiManager;
    }


    public RequestBody getJsonBody(String json){
        RequestBody requestBody=null;
        if(json!=null){
            requestBody = RequestBody.create(MediaType.parse("application/json,charset-UTF-8"), json);
        }
        return requestBody;
    }
}
