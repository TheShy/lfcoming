package com.zwtx.swing.lfcoming.MVP.LFHouse;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.zwtx.swing.lfcoming.MVP.Home.Activity.MainActivity;
import com.zwtx.swing.lfcoming.R;
import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;

import butterknife.BindView;

//资料审核页面
public class DataAuditActivity extends BaseActivity{

    @BindView(R.id.data_audit_btn_shure)
    Button btn_shure;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_data_audit);
    }

    @Override
    protected void findViewById() {
        btn_shure= (Button) findViewById(R.id.data_audit_btn_shure);

    }

    @Override
    protected void setListener() {
        btn_shure.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.data_audit_pass);

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
            case R.id.data_audit_btn_shure:
                Intent data_audit = new Intent(this,MainActivity.class);
                startActivity(data_audit);
                finish();
                break;
        }

    }
}
