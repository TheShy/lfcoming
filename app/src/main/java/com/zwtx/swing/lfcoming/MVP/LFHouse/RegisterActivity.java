package com.zwtx.swing.lfcoming.MVP.LFHouse;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import butterknife.BindView;

/**
 * 注册页面
 */

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.register_et_phone)
    EditText et_phone;
    @BindView(R.id.register_et_code)
    EditText et_code;

    @BindView(R.id.register_btn_getcode)
    Button btn_getcode;
    @BindView(R.id.register_btn_next)
    Button btn_next;

    /**
     * 保存手机号
     */
    private String userPhone;
    /**
     * 验证码
     */
    private String authCode;
    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_register);

    }

    @Override
    protected void findViewById() {
        btn_getcode= (Button) findViewById(R.id.register_btn_getcode);
        btn_next= (Button) findViewById(R.id.register_btn_next);

    }

    @Override
    protected void setListener() {
        btn_next.setOnClickListener(this);
        btn_getcode.setOnClickListener(this);
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
        Intent mIntent = null;
        switch (v.getId()){
            case R.id.register_btn_next:
                mIntent= new Intent(this,SettingPwdActivity.class);
                startActivity(mIntent);
                break;
        }

    }


}
