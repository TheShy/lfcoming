package com.zwtx.swing.lfcoming.MVP.Home.LFFaction;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by SuperSow
 */

public class MyFactionActivity extends BaseActivity {

    @BindView(R.id.myfaction_btn_join)
    Button btn_myjoin;
    @BindView(R.id.myfaction_btn_service)
    Button btn_service;
    @BindView(R.id.myfaction_lv)
    ListView myfaction_lv;

    private List<Map<String, Object>> data;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_myfaction);

    }

    @Override
    protected void findViewById() {
        btn_myjoin = (Button) findViewById(R.id.myfaction_btn_join);
        btn_service = (Button) findViewById(R.id.myfaction_btn_service);
        myfaction_lv= (ListView) findViewById(R.id.myfaction_lv);
    }

    @Override
    protected void setListener() {
        btn_myjoin.setOnClickListener(this);
        btn_service.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.my_faction);


        myfaction_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(MyFactionActivity.this,ServiceDetailsActivity.class);
                startActivity(mIntent);



            }
        });
        data = getData();
        MyAdapter adapter = new MyAdapter(this);
        myfaction_lv.setAdapter(adapter);

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
        Intent mIntent= null;
        switch (v.getId()){
            case R.id.myfaction_btn_join:
                mIntent = new Intent(this,JoinFactionActivity.class);
                startActivity(mIntent);
                break;
            case R.id.myfaction_btn_service:
              mIntent = new Intent(this,SendServiceActivity.class);
                startActivity(mIntent);
                break;

        }

    }
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < 20; i++) {
            map = new HashMap<String, Object>();
            map.put("title", "中网天下");
            map.put("adress", "北京市朝阳双击");
            map.put("heard", R.mipmap.lf_heard);
            map.put("time", "2017-10-24");
            list.add(map);

        }
        return list;
    }
    static class ViewHolder {
        public TextView title, adress, time,num;
        public ImageView img;
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
                convertView = mInflater.inflate(R.layout.llfaction_itme,
                        null);
                holder.title =  convertView
                        .findViewById(R.id.llfaction_tv_title);
                holder.adress =  convertView
                        .findViewById(R.id.llfaction_tv_city);
                holder.time =  convertView
                        .findViewById(R.id.llfaction_tv_time);
                holder.num =  convertView
                        .findViewById(R.id.llfaction_tv_num);
                holder.img =convertView
                        .findViewById(R.id.llfaction_iv_img);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText("北京中网天下");
            holder.time.setText("2017-10-28");
            holder.adress.setText("北京市朝阳双击");
            holder.num.setText("500/456");
            holder.img.setBackgroundResource(R.mipmap.logo);
            return convertView;
        }

    }
}
