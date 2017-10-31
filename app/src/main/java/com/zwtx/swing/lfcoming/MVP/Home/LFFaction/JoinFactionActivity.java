package com.zwtx.swing.lfcoming.MVP.Home.LFFaction;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by SuperSow
 * 已入帮派
 */

public class JoinFactionActivity extends BaseActivity {


    @BindView(R.id.join_faction_tv_start)
    TextView tv_start;

    @BindView(R.id.join_lv)
    ListView join_lv;

    private List<Map<String, Object>> data;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_join_faction);

    }

    @Override
    protected void findViewById() {
        tv_start = (TextView) findViewById(R.id.join_faction_tv_start);
        join_lv= (ListView) findViewById(R.id.join_lv);
    }

    @Override
    protected void setListener() {
        tv_start.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.my_factions);
        join_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(JoinFactionActivity.this,ServiceDetailsActivity.class);
                startActivity(mIntent);

            }
        });
        data = getData();
        MyAdapter adapter = new MyAdapter(this);
        join_lv.setAdapter(adapter);

    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected Context getActivityContext() {
        return null;
    }

    @Override
    public void onClick(View v) {
        Intent mIntent = null;
        switch (v.getId()) {
            case R.id.join_faction_tv_start:
                mIntent = new Intent(this, FoundFActivity.class);
                startActivity(mIntent);
                break;
        }

    }
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < 20; i++) {
            map = new HashMap<String, Object>();

            list.add(map);

        }
        return list;
    }
    static class ViewHolder {
        public TextView name, numb;
        public CircleImageView heard;
    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater = null;

        private MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.join_itme,
                        null);

                holder.numb = (TextView) convertView
                        .findViewById(R.id.join_item_num);
                holder.name = (TextView) convertView
                        .findViewById(R.id.join_item_num);
                holder.heard = (CircleImageView) convertView
                        .findViewById(R.id.join_item_heard);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.numb.setText("450/500");
            holder.name.setText("中网天下");
            holder.heard.setBackgroundResource(R.mipmap.lf_heard);

            return convertView;
        }

    }

}
