package com.zwtx.swing.lfcoming.MVP.Home.presenter;

import com.zwtx.swing.lfcoming.MVP.Entity.HomeDto;
import com.zwtx.swing.lfcoming.MVP.Home.model.HomeFragmentModel;
import com.zwtx.swing.lfcoming.MVP.Home.model.OnLoadDataListListener;
import com.zwtx.swing.lfcoming.MVP.Home.view.HomeFragmentView;

/**
 * Created by SuperSow
 */

public class HomeFragmentPresenter implements OnLoadDataListListener<HomeDto> {

    HomeFragmentView mView;
    HomeFragmentModel mModel;

    public HomeFragmentPresenter(HomeFragmentView mView) {
        this.mView = mView;
        this.mModel=new HomeFragmentModel();
        mView.showProgress();
    }

    public void LoadData(boolean isload){
        mModel.loadData(isload,this);
    }
    @Override
    public void onSuccess(HomeDto data) {
        mView.newDatas(data);
        mView.hideProgress();
    }

    @Override
    public void onFailure(Throwable e) {
        mView.showLoadFailMsg();


    }
}
