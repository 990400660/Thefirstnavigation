package com.example.pc.thefirstnavigation.http;

import android.util.Log;

import com.example.pc.thefirstnavigation.base.module.BaseModuleFinish;

import java.util.logging.Logger;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BaseObserver<T> implements Observer<T> {
    //回调结果处理
    private BaseModuleFinish httpFinishCallback;

    public BaseObserver(BaseModuleFinish httpFinishCallback) {
        this.httpFinishCallback = httpFinishCallback;
    }

    //管理内存网络请求
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void onSubscribe(Disposable d) {
        compositeDisposable.add(d);
    }

    @Override
    public void onError(Throwable e) {
        if (compositeDisposable != null) {

            compositeDisposable.clear();
        }
        if (httpFinishCallback != null) {
            if (e instanceof HttpException) {
                httpFinishCallback.setShowError("网络请求错误");
            } else {
                httpFinishCallback.setShowError("其他请求错误");
            }
            Logger.getLogger(e.getMessage());
            httpFinishCallback.setHideAnimation();
        }


    }

    @Override
    public void onComplete() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
        if (httpFinishCallback != null) {
            httpFinishCallback.setHideAnimation();
        }
    }
}
