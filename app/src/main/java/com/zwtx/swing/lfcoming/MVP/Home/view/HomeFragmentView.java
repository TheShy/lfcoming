package com.zwtx.swing.lfcoming.MVP.Home.view;


import com.zwtx.swing.lfcoming.MVP.Entity.HomeDto;

/**
 * Created by SuperSow
 */

public interface HomeFragmentView {
    //显示加载页
    void showProgress();
    //关闭加载页
    void hideProgress();
    //加载新数据
    void newDatas(HomeDto data);
    //显示加载失败
    void showLoadFailMsg();
}
