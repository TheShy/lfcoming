package com.zwtx.swing.lfcoming.Data.Retrofit;

public interface SubscriberOnNextListener<T> {
    void onNext(T t);
    void onError(Throwable e);
    void onCompleted();
}
