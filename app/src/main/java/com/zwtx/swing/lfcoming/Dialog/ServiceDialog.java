package com.zwtx.swing.lfcoming.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zwtx.swing.lfcoming.R;

import static com.zwtx.swing.lfcoming.R.id.dialog_btn_share;

/**
 * Created by SuperSow
 */

public class ServiceDialog extends Dialog implements View.OnClickListener {



    private Button btn_send,btn_share;
    private TextView tv_send_finsh;
    Context mContext;

    public ServiceDialog(Context context, int theme) {
        super(context, theme);
        mContext = context;
    }

    protected ServiceDialog(Context context, boolean cancelable,
                          OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public ServiceDialog(Context context) {
        super(context);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_service);
        initview();
    }
    public void initview() {
        tv_send_finsh= findViewById(R.id.dialog_tv_send_finsh);
        btn_send =findViewById(R.id.dialog_btn_send);
        btn_share =findViewById(dialog_btn_share);

        btn_share.setOnClickListener(this);
        btn_send.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialog_btn_send:
                dismiss();
                break;
            case dialog_btn_share:
                dismiss();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, mContext.getString(R.string.share));
                intent.putExtra(Intent.EXTRA_TEXT, mContext.getString(R.string.share_contents, mContext.getString(R.string.app_name), dialog_btn_share));
                mContext.startActivity(Intent.createChooser(intent,""));
                break;

        }

    }

}
