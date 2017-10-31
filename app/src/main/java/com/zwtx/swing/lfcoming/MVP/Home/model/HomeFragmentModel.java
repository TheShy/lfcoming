package com.zwtx.swing.lfcoming.MVP.Home.model;

import com.zwtx.swing.lfcoming.Data.HttpData.HttpData;
import com.zwtx.swing.lfcoming.MVP.Entity.HomeDto;

import rx.Observer;

/**
 * Created by SuperSow
 */

public class HomeFragmentModel {


    public void loadData(boolean isload,final OnLoadDataListListener listener){
        HttpData.getInstance().postHomeInfo(isload, new Observer<HomeDto>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.onFailure(e);

            }

            @Override
            public void onNext(HomeDto homeDto) {
                listener.onSuccess(homeDto);

            }
        });

    }
}
