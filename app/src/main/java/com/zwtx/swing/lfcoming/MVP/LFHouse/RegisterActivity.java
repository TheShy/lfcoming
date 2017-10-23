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

public class RegisterActivity extends BaseActivity {


    @BindView(R.id.register_btn_next)
    Button btn_next;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_register);

    }

    @Override
    protected void findViewById() {
        btn_next= (Button) findViewById(R.id.register_btn_next);

    }

    @Override
    protected void setListener() {
        btn_next.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.become_lf);

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
            case R.id.register_btn_next:
                Intent register= new Intent(this,InfromationActivity.class);
                startActivity(register);
                break;
        }

    }
}
