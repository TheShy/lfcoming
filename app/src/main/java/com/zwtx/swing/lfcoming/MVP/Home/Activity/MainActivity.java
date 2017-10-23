package com.zwtx.swing.lfcoming.MVP.Home.Activity;

import android.content.Context;
import android.support.annotation.IdRes;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioGroup;

import com.zwtx.swing.lfcoming.R;
import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.MVP.Home.Fragment.FragmentController;
import com.zwtx.swing.lfcoming.Dialog.MyDialogHint;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.hometab_radio)
    RadioGroup hometabRadio;

    private FragmentController controller;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
        controller = FragmentController.getInstance(this, R.id.hometab_context);
        controller.showFragment(0);

    }

    @Override
    protected void findViewById() {
        hometabRadio = (RadioGroup) findViewById(R.id.hometab_radio);

    }

    @Override
    protected void setListener() {
        hometabRadio.setOnCheckedChangeListener(this);

    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FragmentController.onDestroy();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_recommend:
                controller.showFragment(0);
                break;
            case R.id.rb_stack:
                controller.showFragment(1);
                break;
            case R.id.rb_search:
                controller.showFragment(2);
                break;
            case R.id.rb_download:
                controller.showFragment(3);

                break;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (((keyCode == KeyEvent.KEYCODE_BACK) ||
                (keyCode == KeyEvent.KEYCODE_HOME))
                && event.getRepeatCount() == 0) {
            new MyDialogHint(this,R.style.MyDialog1).show();
        }
        return false;
    }
}
