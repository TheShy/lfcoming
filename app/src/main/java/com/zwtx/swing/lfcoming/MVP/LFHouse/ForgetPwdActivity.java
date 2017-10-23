package com.zwtx.swing.lfcoming.MVP.LFHouse;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.MVP.Home.Activity.MainActivity;
import com.zwtx.swing.lfcoming.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/21/021.
 */

public class ForgetPwdActivity extends BaseActivity {


    @BindView(R.id.forget_btn_shure)
    Button btn_shure;

    @Override
    protected void loadViewLayout() {

        setContentView(R.layout.activity_forget_pwd);

    }

    @Override
    protected void findViewById() {
        btn_shure = (Button) findViewById(R.id.forget_btn_shure);
    }

    @Override
    protected void setListener() {
        btn_shure.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.forget_pwd);
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
        switch (v.getId()) {
            case R.id.forget_btn_shure:
                Intent mIntent = new Intent(this, MainActivity.class);
                startActivity(mIntent);
                break;
        }

    }
}
