package com.zwtx.swing.lfcoming.MVP.Home.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zaaach.citypicker.CityPickerActivity;
import com.zwtx.swing.lfcoming.MVP.Base.BaseFragment;
import com.zwtx.swing.lfcoming.MVP.Home.CallLF.CallLFActivity;
import com.zwtx.swing.lfcoming.MVP.Home.LFFaction.LFFactionActivity;
import com.zwtx.swing.lfcoming.MVP.Home.LFList.LFListActivity;
import com.zwtx.swing.lfcoming.MVP.Home.MyStudyLF.MyStudyLFActivity;
import com.zwtx.swing.lfcoming.R;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;

import static android.app.Activity.RESULT_OK;


public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private static final int REQUEST_CODE_PICK_CITY = 0;//启动

    @BindView(R.id.home_tv_city)
    TextView tv_city;
    @BindView(R.id.home_banner)
    BGABanner mBanner;
    @BindView(R.id.home_tv_study_lf)
    TextView tv_studyt;
    @BindView(R.id.home_tv_lfb)
    TextView tv_lfb;

    @BindView(R.id.home_heard_layout_call)
    LinearLayout layout_call;

    @BindView(R.id.hoem_heard_tv_call)
    TextView tv_call;

    @BindView(R.id.home_iv_lfbang)
    ImageView iv_lfb;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initListener() {
        tv_city.setOnClickListener(this);
        tv_studyt.setOnClickListener(this);
        tv_lfb.setOnClickListener(this);
        layout_call.setOnClickListener(this);
        tv_call.setOnClickListener(this);
        iv_lfb.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        tv_city = getActivity().findViewById(R.id.home_tv_city);
        tv_studyt=getActivity().findViewById(R.id.home_tv_study_lf);
        tv_lfb=getActivity().findViewById(R.id.home_tv_lfb);
        layout_call=getActivity().findViewById(R.id.home_heard_layout_call);
        tv_call=getActivity().findViewById(R.id.hoem_heard_tv_call);
        mBanner=getActivity().findViewById(R.id.home_banner);
        mBanner.setData(R.mipmap.vp_first,R.mipmap.vp_second,R.mipmap.vp_third);
        iv_lfb=getActivity().findViewById(R.id.home_iv_lfbang);


    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initListener();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                tv_city.setText( city);
            }
        }

    }

    @Override
    public void onClick(View v) {
        Intent mIntent =null;
        switch (v.getId()){
            case R.id.home_tv_city:
                startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;
            case R.id.home_tv_study_lf:
                mIntent = new Intent(getActivity(), MyStudyLFActivity.class);
                startActivity(mIntent);
                break;
            case R.id.home_tv_lfb:
                mIntent = new Intent(getActivity(), LFFactionActivity.class);
                startActivity(mIntent);
                break;
            case R.id.hoem_heard_tv_call:
                mIntent = new Intent(getActivity(), CallLFActivity.class);
                startActivity(mIntent);
                break;
            case R.id.home_iv_lfbang:
                mIntent = new Intent(getActivity(), LFListActivity.class);
                startActivity(mIntent);
                break;
        }
    }


}