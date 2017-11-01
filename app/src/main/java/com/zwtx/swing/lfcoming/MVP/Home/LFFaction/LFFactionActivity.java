package com.zwtx.swing.lfcoming.MVP.Home.LFFaction;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.http.HEAD;

/**
 * Created by SuperSow
 * LF帮
 */

public class LFFactionActivity extends BaseActivity {


    @BindView(R.id.lffaciton_tab)
    TabLayout mTabLayout;
    @BindView(R.id.lffaciton_vp)
    ViewPager mViewPager;

    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合

    private RecyclerView mView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_faction);

    }

    @Override
    protected void findViewById() {
        mTabLayout = (TabLayout) findViewById(R.id.lffaciton_tab);
        mViewPager = (ViewPager) findViewById(R.id.lffaciton_vp);


    }

    @Override
    protected void setListener() {
        setTitleLeftBtn();
        setTitleName(R.string.lfb);

    }

    @Override
    protected void processLogic() {
        mInflater = LayoutInflater.from(this);
        //LF帮
        view1 = mInflater.inflate(R.layout.activityi_llfaciton_list, null);
        //我的LF帮
        view2 = mInflater.inflate(R.layout.activity_myfaction, null);
        //创建雷锋帮
        view3 = mInflater.inflate(R.layout.activitiy_send_faction, null);
        mView= (RecyclerView) findViewById(R.id.llfaction_recycler_h);


//        Button btn_faction = view1.findViewById(R.id.btn_faction);
//        btn_faction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent mIntent = new Intent(LFFactionActivity.this,MyFactionActivity.class);
//                startActivity(mIntent);
//            }
//        });

        RecyclerView mRecyclerView = view1.findViewById(R.id.home_recycler_hot);


        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

        mTitleList.add("LF帮");
        mTitleList.add("我的LF帮");
        mTitleList.add("创建LF帮");

        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));


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


}
