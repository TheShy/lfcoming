package com.zwtx.swing.lfcoming.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.zwtx.swing.lfcoming.MyApplication;
import com.zwtx.swing.lfcoming.R;

/**
 * Created by SuperSow
 */

public class EditDialog extends Dialog implements OnClickListener {

    Context mContext;
    private TextView tv_title,tv_cancle,tv_finsh;

    public EditDialog(Context context, int theme) {
        super(context, theme);
        mContext = context;
    }

    protected EditDialog(Context context, boolean cancelable,
                            OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public EditDialog(Context context) {
        super(context);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_edit);
        initView();
    }

    private void initView() {
        tv_title =findViewById(R.id.edit_tv_title);
        tv_cancle=findViewById(R.id.edit_tv_cancle);
        tv_finsh=findViewById(R.id.edit_tv_finsh);

        tv_cancle.setOnClickListener(this);
        tv_finsh.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit_tv_cancle:
                dismiss();
                break;
            case R.id.edit_tv_finsh:
                MyApplication.getInstance().exitActivitys();
                dismiss();
                break;
        }
    }

}
