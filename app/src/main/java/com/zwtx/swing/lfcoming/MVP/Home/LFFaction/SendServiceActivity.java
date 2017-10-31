package com.zwtx.swing.lfcoming.MVP.Home.LFFaction;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zwtx.swing.lfcoming.Dialog.EditDialog;
import com.zwtx.swing.lfcoming.Dialog.ServiceDialog;
import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import butterknife.BindView;

/**
 * Created by SuperSow
 * 发布任务
 */

public class SendServiceActivity extends BaseActivity {

    @BindView(R.id.service_btn_shure)
    Button btn_service;

    @BindView(R.id.service_iv_back)
    ImageView iv_back;

    @Override
    protected void loadViewLayout() {

    setContentView(R.layout.activity_service);
    }

    @Override
    protected void findViewById() {
        btn_service = (Button) findViewById(R.id.service_btn_shure);
        iv_back= (ImageView) findViewById(R.id.service_iv_back);
    }

    @Override
    protected void setListener() {
        btn_service.setOnClickListener(this);
        iv_back.setOnClickListener(this);
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
        switch (v.getId()){
            case R.id.service_btn_shure:
                new ServiceDialog(this, R.style.MyDialog1).show();
                break;
            case R.id.service_iv_back:
                new EditDialog(this,R.style.MyDialog1).show();
                break;
        }

    }
}
