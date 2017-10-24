package com.zwtx.swing.lfcoming.MVP.LFHouse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.MVP.Home.Activity.MainActivity;
import com.zwtx.swing.lfcoming.R;
import com.zwtx.swing.lfcoming.Utils.FoToast;

import butterknife.BindView;

/**
 * 登陆页面
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_btn)
    Button btn_login;

    @BindView(R.id.login_et_phone)
    EditText et_phone;
    @BindView(R.id.login_et_pwd)
    EditText et_pwd;

    @BindView(R.id.login_tv_lf)
    TextView tv_lf;
    @BindView(R.id.login_tv_forget_pwd)
    TextView tv_forget_pwd;

    @BindView(R.id.login_iv_qq)
    ImageView iv_qq;
    @BindView(R.id.login_iv_wechat)
    ImageView iv_wechat;
    @BindView(R.id.login_iv_weibo)
    ImageView iv_weibo;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activitiy_login);
    }

    @Override
    protected void findViewById() {
        btn_login = (Button) findViewById(R.id.login_btn);
        tv_lf = (TextView) findViewById(R.id.login_tv_lf);
        tv_forget_pwd = (TextView) findViewById(R.id.login_tv_forget_pwd);
        iv_qq = (ImageView) findViewById(R.id.login_iv_qq);
        iv_wechat = (ImageView) findViewById(R.id.login_iv_wechat);
        iv_weibo = (ImageView) findViewById(R.id.login_iv_weibo);

    }

    @Override
    protected void setListener() {
        btn_login.setOnClickListener(this);
        tv_lf.setOnClickListener(this);
        tv_forget_pwd.setOnClickListener(this);
        iv_qq.setOnClickListener(this);
        iv_wechat.setOnClickListener(this);
        iv_weibo.setOnClickListener(this);


    }

    @Override
    protected void processLogic() {

        tv_lf.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        tv_lf.getPaint().setAntiAlias(true);//抗锯齿
        tv_forget_pwd.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        tv_forget_pwd.getPaint().setAntiAlias(true);//抗锯齿

    }

    @Override
    protected Context getActivityContext() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                Intent login = new Intent(this, MainActivity.class);
                startActivity(login);
                finish();
                break;
            case R.id.login_tv_lf:
                Intent register = new Intent(this, RegisterActivity.class);
                startActivity(register);
                break;
            case R.id.login_tv_forget_pwd:
                Intent forget = new Intent(this, ForgetPwdActivity.class);
                startActivity(forget);
                break;
            case R.id.login_iv_qq:
                FoToast.showToast("暂未开放");
                break;
            case R.id.login_iv_wechat:
                FoToast.showToast("暂未开放");
                break;
            case R.id.login_iv_weibo:
                FoToast.showToast("暂未开放");
                break;
        }

    }


}
