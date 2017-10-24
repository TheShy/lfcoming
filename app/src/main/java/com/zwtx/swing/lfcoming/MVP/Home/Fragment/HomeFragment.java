package com.zwtx.swing.lfcoming.MVP.Home.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zaaach.citypicker.CityPickerActivity;
import com.zwtx.swing.lfcoming.MVP.Base.BaseFragment;
import com.zwtx.swing.lfcoming.MVP.Home.MyStudyLF.MyStudyLFActivity;
import com.zwtx.swing.lfcoming.R;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;

import static android.app.Activity.RESULT_OK;


public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private static final int REQUEST_CODE_PICK_CITY = 0;//启动

    @BindView(R.id.home_bnt_city)
    Button btn_city;
    @BindView(R.id.home_banner)
    BGABanner mBanner;
    @BindView(R.id.home_tv_study_lf)
    TextView tv_studyt;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initListener() {
        btn_city.setOnClickListener(this);
        tv_studyt.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        btn_city = getActivity().findViewById(R.id.home_bnt_city);
        tv_studyt=getActivity().findViewById(R.id.home_tv_study_lf);
        mBanner=getActivity().findViewById(R.id.home_banner);
        mBanner.setData(R.mipmap.vp_first,R.mipmap.vp_second,R.mipmap.vp_third);
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
                btn_city.setText("当前选择：" + city);
            }
        }

    }

    @Override
    public void onClick(View v) {
        Intent mIntent =null;
        switch (v.getId()){
            case R.id.home_bnt_city:
                startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;
            case R.id.home_tv_study_lf:
                mIntent = new Intent(getActivity(), MyStudyLFActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}