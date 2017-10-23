package com.zwtx.swing.lfcoming.MVP.Home.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zaaach.citypicker.CityPickerActivity;
import com.zwtx.swing.lfcoming.MVP.Base.BaseFragment;
import com.zwtx.swing.lfcoming.MVP.Home.MyStudyLF.MyStudyLFActivity;
import com.zwtx.swing.lfcoming.R;

import cn.bingoogolapple.bgabanner.BGABanner;

import static android.app.Activity.RESULT_OK;


public class HomeFragment extends BaseFragment  {

    private static final int REQUEST_CODE_PICK_CITY = 0;//启动


    private Button btn_city;

    private TextView tv_xlf, tv_hjlf, tv_sblf;


    private BGABanner mBanner;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn_city = getActivity().findViewById(R.id.home_bnt_city);
        btn_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
            }
        });
        tv_xlf = getActivity().findViewById(R.id.home_tv_student_lf);
        tv_xlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent study = new Intent(getActivity(), MyStudyLFActivity.class);
                startActivity(study);
            }
        });
        tv_hjlf = getActivity().findViewById(R.id.home_tv_hjlf);
        tv_hjlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hjlf = new Intent(getActivity(), MyStudyLFActivity.class);
                startActivity(hjlf);
            }
        });
        tv_sblf = getActivity().findViewById(R.id.home_tv_sblf);
        tv_sblf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sblf = new Intent(getActivity(), MyStudyLFActivity.class);
                startActivity(sblf);
            }
        });

        mBanner=getActivity().findViewById(R.id.banner_guide_content);
        mBanner.setData(R.mipmap.uoko_guide_background_1,R.mipmap.uoko_guide_background_2,R.mipmap.uoko_guide_background_3);
        mBanner.setDelegate(new BGABanner.Delegate<ImageView, String>() {
            @Override
            public void onBannerItemClick(BGABanner banner, ImageView itemView, String model, int position) {
                Toast.makeText(banner.getContext(), "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
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

}