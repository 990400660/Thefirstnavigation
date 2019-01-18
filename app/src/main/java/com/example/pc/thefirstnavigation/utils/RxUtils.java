package com.example.pc.thefirstnavigation.utils;

import com.example.pc.thefirstnavigation.beans.BaseDemo;
import com.example.pc.thefirstnavigation.http.ApiException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.functions.Function;
public class RxUtils {




    public static <T>ObservableTransformer<T,T>rxScheduleThread(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }




    public static <T> ObservableTransformer<BaseDemo<T>,T>handleResult(){

        return new ObservableTransformer<BaseDemo<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseDemo<T>> upstream) {

                return upstream.flatMap(new Function<BaseDemo<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(BaseDemo<T> tHttpResponse) throws Exception {
                        if(tHttpResponse.getCode()==0){
                            return createData(tHttpResponse.getT());
                        }else{

                            return Observable.error(new ApiException(tHttpResponse.getCode(),tHttpResponse.getMessage()));
                        }
                    }
                }) ;
            }
        };
    }






    public static  <T> Observable<T> createData(final T t){
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                }catch (Exception e){
                    emitter.onError(e);
                }
            }
        });
    }
}
