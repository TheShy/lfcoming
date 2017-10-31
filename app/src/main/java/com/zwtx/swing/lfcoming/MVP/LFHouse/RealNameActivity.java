package com.zwtx.swing.lfcoming.MVP.LFHouse;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import java.io.File;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * 实名认证页面
 */
public class RealNameActivity extends BaseActivity {

    @BindView(R.id.information_btn_comit)
    Button btn_comit;
    @BindView(R.id.real_iv_heard)
    CircleImageView iv_heard;
    /**
     * 创建一个以当前时间为名称的文件
     */
    private File tempFile = null;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_infromation);
    }

    @Override
    protected void findViewById() {
        btn_comit = (Button) findViewById(R.id.information_btn_comit);
        iv_heard = (CircleImageView) findViewById(R.id.real_iv_heard);

    }

    @Override
    protected void setListener() {
        btn_comit.setOnClickListener(this);
        iv_heard.setOnClickListener(this);
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
        Intent mIntent = null;
        switch (v.getId()) {
            case R.id.information_btn_comit:
                mIntent = new Intent(this, ChusNumberActivity.class);
                startActivity(mIntent);
                break;
            case R.id.real_iv_heard:
                break;

        }

    }


}
