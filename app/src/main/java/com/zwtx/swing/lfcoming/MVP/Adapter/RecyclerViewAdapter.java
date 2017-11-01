package com.zwtx.swing.lfcoming.MVP.Adapter;

import android.support.v4.content.ContextCompat;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zwtx.swing.lfcoming.MVP.Entity.ListInfo;
import com.zwtx.swing.lfcoming.R;

import java.util.List;


/**
 * Created by Fliest on 2017/10/31.
 */

public class RecyclerViewAdapter extends BaseMultiItemQuickAdapter<ListInfo, BaseViewHolder> {
    public static final int TYPE = 1;
    public static final int NORMALTYPE = 0;


    public RecyclerViewAdapter(List<ListInfo> data) {
        super(data);

        addItemType(TYPE, R.layout.item_lf_list);
        addItemType(NORMALTYPE, R.layout.item_lf_list_normal);

    }


    @Override
    protected void convert(BaseViewHolder helper, ListInfo item) {
        switch (helper.getItemViewType()) {
            case TYPE:
                int color = item.getColor();
                int id = item.getSortId();
                helper.setText(R.id.lf_list_sort_id, String.valueOf(id));
                helper.setText(R.id.lf_list_name, item.getName());
                helper.setText(R.id.lf_list_user_id, item.getId());
                helper.setText(R.id.lf_list_score, String.valueOf(item.getScore()));

                //设置前三行的背景和颜色
                if (color != 0) {
                    switch (id) {
                        case 1:
                            helper.setBackgroundColor(R.id.lf_list_ll, ContextCompat.getColor(mContext, R.color.lf_list_ll_first_bg));
                            break;
                        case 2:
                            helper.setBackgroundColor(R.id.lf_list_ll, ContextCompat.getColor(mContext, R.color.lf_list_ll_second_bg));
                            break;
                        case 3:
                            helper.setBackgroundColor(R.id.lf_list_ll, ContextCompat.getColor(mContext, R.color.lf_list_ll_third_bg));
                            break;
                        default:
                    }
                }
                break;

            case NORMALTYPE:
                helper.setText(R.id.lf_list_normal_sort_id, String.valueOf(item.getSortId()));
                helper.setText(R.id.lf_list_normal_name, item.getName());
                helper.setText(R.id.lf_list_normal_user_id, item.getId());
                helper.setText(R.id.lf_list_normal_score, String.valueOf(item.getScore()));
                break;
            default:
        }

    }
}
