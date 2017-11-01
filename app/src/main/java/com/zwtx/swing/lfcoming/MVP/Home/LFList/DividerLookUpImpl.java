package com.zwtx.swing.lfcoming.MVP.Home.LFList;

import android.graphics.Color;

import com.choices.divider.Divider;
import com.choices.divider.DividerItemDecoration;
import com.zwtx.swing.lfcoming.MVP.Adapter.RecyclerViewAdapter;

/**
 * Created by Fliest on 2017/10/31.
 */

public class DividerLookUpImpl extends DividerItemDecoration.SimpleDividerLookup {
    private RecyclerViewAdapter mAdapter;

    public DividerLookUpImpl(RecyclerViewAdapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public Divider getHorizontalDivider(int position) {
        int type = mAdapter.getItemViewType(position);
        switch (type) {
            case 0:
                return new Divider.Builder()
                        .size(2)
                        .color(Color.GRAY)
                        .build();
            case 1:
                return new Divider.Builder()
                        .size(2)
                        .color(Color.WHITE)
                        .build();

            default:
                break;
        }
        return null;
    }

    @Override
    public Divider getVerticalDivider(int position) {
        int type = mAdapter.getItemViewType(position);
        switch (type) {
            case 0:
                return new Divider.Builder()
                        .size(2)
                        .color(Color.GRAY)
                        .build();
            case 1:
                return new Divider.Builder()
                        .size(2)
                        .color(Color.WHITE)
                        .build();

            default:
                break;
        }
        return null;
    }
}
