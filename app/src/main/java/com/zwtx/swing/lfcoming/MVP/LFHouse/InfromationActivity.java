package com.zwtx.swing.lfcoming.MVP.LFHouse;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.zwtx.swing.lfcoming.R;
import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;

import butterknife.BindView;


/**
 * Created by Administrator on 2017/10/19/019.
 */

public class InfromationActivity extends BaseActivity {

    @BindView(R.id.information_btn_comit)
    Button btn_comit;

    @Override
    protected void loadViewLayout() {
    setContentView(R.layout.activity_infromation);
    }

    @Override
    protected void findViewById() {
        btn_comit= (Button) findViewById(R.id.information_btn_comit);

    }

    @Override
    protected void setListener() {
        btn_comit.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.real_name);

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
        switch (v.getId()){
            case R.id.information_btn_comit:
                Intent information = new Intent(this,DataAuditActivity.class);
                startActivity(information);
                finish();
                break;
        }

    }
}
