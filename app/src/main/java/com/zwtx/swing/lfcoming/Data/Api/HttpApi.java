package com.zwtx.swing.lfcoming.Data.Api;

import com.zwtx.swing.lfcoming.MVP.Entity.HomeDto;
import com.zwtx.swing.lfcoming.MVP.Entity.HttpResult;

import retrofit2.http.POST;
import rx.Observable;

/**
 *
 * API接口
 * 因为使用RxCache作为缓存策略 所以这里不需要写缓存信息
 */

public interface HttpApi {


    //获取首页Banner
    @POST("carouse")
    Observable<HttpResult<HomeDto>> postHomeInfo();

}
