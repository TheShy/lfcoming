package com.zwtx.swing.lfcoming.MVP.LFHouse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.MVP.Home.Activity.MainActivity;
import com.zwtx.swing.lfcoming.R;

import java.util.Map;

import butterknife.BindView;

/**
 * 登陆页面
 */

public class LoginActivity extends BaseActivity {
    private String TAG = this.getClass().getSimpleName();

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

    private String userName;


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


    //授权
    private void authorization(SHARE_MEDIA share_media) {
        UMShareAPI.get(this).getPlatformInfo(this, share_media, new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {
                Log.d(TAG, "onStart " + "授权开始");
            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                Log.d(TAG, "onComplete " + "授权完成");

                //sdk是6.4.4的,但是获取值的时候用的是6.2以前的(access_token)才能获取到值,未知原因
                String uid = map.get("uid");
                String openid = map.get("openid");//微博没有
                String unionid = map.get("unionid");//微博没有
                String access_token = map.get("access_token");
                String refresh_token = map.get("refresh_token");//微信,qq,微博都没有获取到
                String expires_in = map.get("expires_in");
                String name = map.get("name");
                String gender = map.get("gender");
                String iconurl = map.get("iconurl");
                Toast.makeText(getApplicationContext(), "name=" + name + ",gender=" + gender, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                Log.d(TAG, "onError " + "授权失败");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                Log.d(TAG, "onCancel " + "授权取消");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onClick(View v) {
        Intent mIntent = null;
        switch (v.getId()) {
            case R.id.login_btn:
                mIntent = new Intent(this, MainActivity.class);
                startActivity(mIntent);
                break;
            case R.id.login_tv_lf:
                mIntent = new Intent(this, RegisterActivity.class);
                startActivity(mIntent);
                break;
            case R.id.login_tv_forget_pwd:
                mIntent = new Intent(this, ForgetPwdActivity.class);
                startActivity(mIntent);
                break;
            case R.id.login_iv_qq:
                authorization(SHARE_MEDIA.QQ);
                break;
            case R.id.login_iv_wechat:
                authorization(SHARE_MEDIA.WEIXIN);
                break;
            case R.id.login_iv_weibo:
                authorization(SHARE_MEDIA.SINA);
                break;
        }


    }



}
