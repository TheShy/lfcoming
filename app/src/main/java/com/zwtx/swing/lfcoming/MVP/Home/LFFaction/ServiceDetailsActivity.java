package com.zwtx.swing.lfcoming.MVP.Home.LFFaction;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import butterknife.BindView;

/**
 * Created by SuperSow
 */

public class ServiceDetailsActivity extends BaseActivity {


    @BindView(R.id.service_detalis_iv_share)
    ImageView iv_share;



    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_service_details);
    }

    @Override
    protected void findViewById() {
        iv_share= (ImageView) findViewById(R.id.service_detalis_iv_share);

    }

    @Override
    protected void setListener() {
        iv_share.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.service_detal);
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
            case R.id.service_detalis_iv_share:

                break;
        }

    }
}
