package com.zwtx.swing.lfcoming.MVP.Home.CallLF;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;
import com.zwtx.swing.lfcoming.Utils.FoToast;

import butterknife.BindView;

/**
 * Created by SuperSow
 */

public class CallLFActivity extends BaseActivity {


    @BindView(R.id.call_tv_city)
    TextView tv_gps;

    @BindView(R.id.call_im_share)
    ImageView iv_share;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_call_lf);

    }

    @Override
    protected void findViewById() {
        tv_gps = (TextView) findViewById(R.id.call_tv_city);
        iv_share= (ImageView) findViewById(R.id.call_im_share);
    }

    @Override
    protected void setListener() {
        tv_gps.setOnClickListener(this);
        iv_share.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.must_help);

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
        switch (v.getId()) {
            case R.id.call_tv_city:
                mIntent = new Intent(this, HelpAdressActivity.class);
                startActivity(mIntent);
                break;
            case R.id.call_im_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share));
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_contents, getString(R.string.app_name), iv_share));
                startActivity(Intent.createChooser(intent, getTitle()));
                break;
        }

    }
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            FoToast.toast(mContext,"成功了");
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            FoToast.toast(mContext,"失败");
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            FoToast.toast(mContext,"取消了");


        }
    };
}
