package com.zwtx.swing.lfcoming.MVP.Home.LFList;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;

import com.choices.divider.DividerItemDecoration;
import com.zwtx.swing.lfcoming.MVP.Adapter.LfListViewPagerAdapter;
import com.zwtx.swing.lfcoming.MVP.Adapter.RecyclerViewAdapter;
import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.MVP.Entity.ListInfo;
import com.zwtx.swing.lfcoming.R;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Fliest on 2017/10/30.
 */

public class LFListActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.list_tl_title)
    TabLayout tabLayout;
    @BindView(R.id.list_vp_container)
    ViewPager viewPager;


        public static final String[] TITLE_LIST = new String[]{"总榜", "地方排行", "个人排行", "团队排行", "行业排行"};
        private ArrayList<View> views;



    private ArrayList<RecyclerViewAdapter> mAdapterList;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_list);

    }

    @Override
    protected void findViewById() {
        setTitleName(R.string.my_list);
        setTitleLeftBtn();

        tabLayout = (TabLayout) findViewById(R.id.list_tl_title);
        viewPager = (ViewPager) findViewById(R.id.list_vp_container);


        LfListViewPagerAdapter adapter = new LfListViewPagerAdapter(getData());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void setListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }


    @Override
    protected void processLogic() {

    }

    @Override
    protected Context getActivityContext() {
        return null;
    }

    @Override
    public void onClick(View view) {

    }

    private ArrayList<View> getData() {
        views = new ArrayList();

        View view1 = LayoutInflater.from(this).inflate(R.layout.view_lf_list, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.view_lf_list, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.view_lf_list, null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.view_lf_list, null);
        View view5 = LayoutInflater.from(this).inflate(R.layout.view_lf_list, null);

        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);


        int size = views.size();
        mAdapterList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            RadioGroup radioGroup = views.get(i).findViewById(R.id.lf_list_rg);
            radioGroup.check(R.id.lf_list_rb_rb);
            radioGroup.setOnCheckedChangeListener(this);

            RecyclerView recyclerView = views.get(i).findViewById(R.id.rv_lf_list);
            initRecyclerView(recyclerView);
        }

        return views;
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
        switch (checkId) {
            case R.id.lf_list_rb_rb:
                refreshRecyclerView();
                break;
            case R.id.lf_list_rb_zb:
                refreshRecyclerView();
                break;
            case R.id.lf_list_rb_yb:
                refreshRecyclerView();
                break;
            default:
        }
    }

    private void refreshRecyclerView() {
        int id = viewPager.getCurrentItem();
        RecyclerViewAdapter adapter = mAdapterList.get(id);
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }

    }


    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView(RecyclerView recyclerView) {
        ArrayList<ListInfo> data = new ArrayList();
        for (int i = 0; i < 10; i++) {
            int color = 0;
            int type = 0;
            if (i < 3) {
                color = 1;
                type = 1;
            }

            ListInfo info = ListInfoBuilder.build()
                    .setSortID(i + 1)
                    .setName("name")
                    .setID("ID999999")
                    .setScore(4050)
                    .setColor(color)
                    .setItemType(type)
                    .builder();

            data.add(info);
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        //设置ItemDecoration
        DividerItemDecoration itemDecoration = new DividerItemDecoration();
        itemDecoration.setDividerLookup(new DividerLookUpImpl(adapter));
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setAdapter(adapter);

        mAdapterList.add(adapter);

        //设置条目点击事件
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });


    }
}
