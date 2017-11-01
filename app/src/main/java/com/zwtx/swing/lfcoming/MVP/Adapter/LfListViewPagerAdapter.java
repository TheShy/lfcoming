package com.zwtx.swing.lfcoming.MVP.Adapter;

import android.view.View;

import com.zwtx.swing.lfcoming.MVP.Home.LFList.LFListActivity;

import java.util.List;

/**
 * Created by Fliest on 2017/10/30.
 */

public class LfListViewPagerAdapter extends ViewPagerAdapter {


    public LfListViewPagerAdapter(List<View> viewList) {
        super(viewList);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return LFListActivity.TITLE_LIST[position];
    }


}
