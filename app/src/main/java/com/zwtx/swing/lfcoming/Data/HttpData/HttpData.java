package com.zwtx.swing.lfcoming.Data.HttpData;

import com.zwtx.swing.lfcoming.Data.Api.CacheProviders;
import com.zwtx.swing.lfcoming.Data.Api.HttpApi;
import com.zwtx.swing.lfcoming.Data.Retrofit.ApiException;
import com.zwtx.swing.lfcoming.Data.Retrofit.RetrofitUtils;
import com.zwtx.swing.lfcoming.MVP.Entity.HomeDto;
import com.zwtx.swing.lfcoming.MVP.Entity.HttpResult;
import com.zwtx.swing.lfcoming.Utils.FileUtil;

import java.io.File;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.Reply;
import io.rx_cache.internal.RxCache;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/*Created by SuperSow
 *所有的请求数据的方法集中地
 * 根据MovieService的定义编写合适的方法
 * 其中observable是获取API数据
 * observableCahce获取缓存数据
 * new EvictDynamicKey(false) false使用缓存  true 加载数据不使用缓存
 */

public class HttpData extends RetrofitUtils {

    private static File cacheDirectory = FileUtil.getcacheDirectory();
    private static final CacheProviders providers = new RxCache.Builder()
            .persistence(cacheDirectory)
            .using(CacheProviders.class);
    protected static final HttpApi service = getRetrofit().create(HttpApi.class);

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpData INSTANCE = new HttpData();
    }

    //获取单例
    public static HttpData getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public void postHomeInfo(boolean isload, Observer<HomeDto> observer) {
        Observable observable = service.postHomeInfo().map(new HttpResultFunc<HomeDto>());
        Observable observableCache = providers.postHomeInfo(observable, new DynamicKey("首页配置"), new EvictDynamicKey(isload)).map(new HttpResultFuncCcche<HomeDto>());
        setSubscribe(observableCache, observer);
    }

    /**
     * 插入观察者
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getCode() != 1) {
                throw new ApiException(httpResult);
            }
            return httpResult.getData();
        }
    }

    /**
     * 用来统一处理RxCacha的结果
     */
    private class HttpResultFuncCcche<T> implements Func1<Reply<T>, T> {

        @Override
        public T call(Reply<T> httpResult) {
            return httpResult.getData();
        }
    }
}
