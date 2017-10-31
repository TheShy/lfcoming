package com.zwtx.swing.lfcoming.MVP.Home.LFFaction;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
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
 * 创业帮
 */

public class StartFactionActivity  extends BaseActivity{

    @BindView(R.id.start_faction_tab)
    TabLayout mTabLayout;
    @BindView(R.id.start_faction_vp)
    ViewPager mViewPager;

    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合

    private List<Map<String, Object>> data;

    @Override
    protected void loadViewLayout() {
    setContentView(R.layout.acitvity_start_faction);
    }

    @Override
    protected void findViewById() {
        mTabLayout = (TabLayout) findViewById(R.id.start_faction_tab);
        mViewPager = (ViewPager) findViewById(R.id.start_faction_vp);
    }

    @Override
    protected void setListener() {
        setTitleLeftBtn();
        setTitleName(R.string.start_faction);
    }

    @Override
    protected void processLogic() {
        mInflater = LayoutInflater.from(this);
        view1 = mInflater.inflate(R.layout.start_faction_list, null);
        view2 = mInflater.inflate(R.layout.start_faction_list, null);


        ListView mListView =view1.findViewById(R.id.start_faction_lv);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(StartFactionActivity.this,ServiceDetailsActivity.class);

            }
        });
        data = getData();
        MyAdapter adapter = new MyAdapter(this);
        mListView.setAdapter(adapter);

        mViewList.add(view1);
        mViewList.add(view2);

        mTitleList.add("活动");
        mTitleList.add("成员");

        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));


        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
    }

    @Override
    protected Context getActivityContext() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }

    //ViewPager适配器
    class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
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
