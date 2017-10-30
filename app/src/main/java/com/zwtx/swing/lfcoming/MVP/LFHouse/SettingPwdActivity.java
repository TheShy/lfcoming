package com.zwtx.swing.lfcoming.MVP.LFHouse;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import butterknife.BindView;

/**
 * Created by SuperSow
 */

public class SettingPwdActivity extends BaseActivity {

    @BindView(R.id.setiing_btn_shure)
    Button btn_shure;

    @Override
    protected void loadViewLayout() {

        setContentView(R.layout.activity_setting_pwd);

    }

    @Override
    protected void findViewById() {
        btn_shure= (Button) findViewById(R.id.setiing_btn_shure);


    }

    @Override
    protected void setListener() {
        btn_shure.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.setting_pwd);

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
            case R.id.setiing_btn_shure:
                    mIntent = new Intent(this,RealNameActivity.class);
                startActivity(mIntent);
                break;

        }

    }
}
