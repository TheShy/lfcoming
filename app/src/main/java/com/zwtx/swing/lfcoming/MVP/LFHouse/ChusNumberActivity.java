package com.zwtx.swing.lfcoming.MVP.LFHouse;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import butterknife.BindView;

/**
 * 选择雷峰号页面
 */

public class ChusNumberActivity extends BaseActivity {


    @BindView(R.id.chus_et_phone)
    MultiAutoCompleteTextView et_phone;

    @BindView(R.id.chus_btn_become)
    Button btn_become;
    @BindView(R.id.chus_btn_shure)
    Button btn_shure;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_chus_num);

    }

    @Override
    protected void findViewById() {
        btn_become= (Button) findViewById(R.id.chus_btn_become);
        btn_shure= (Button) findViewById(R.id.chus_btn_shure);
        et_phone = (MultiAutoCompleteTextView) findViewById(R.id.chus_et_phone);
    }

    @Override
    protected void setListener() {
        btn_become.setOnClickListener(this);
        btn_shure.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.chus_num_lf);

    }

    @Override
    protected void processLogic() {

        String[] strings = {"123","1234","12345","123456"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout
                .simple_expandable_list_item_1,strings);
        //设置适配器的样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        et_phone.setAdapter(adapter);
        //给多文本提示输入框设置分隔符
        et_phone.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }

    @Override
    protected Context getActivityContext() {
        return null;
    }

    @Override
    public void onClick(View v) {
        Intent mIntent =null;
        switch (v.getId()){
            case R.id.chus_btn_become:
                finish();
                break;
            case R.id.chus_btn_shure:
                mIntent = new Intent(this,DataAuditActivity.class);
                startActivity(mIntent);
                break;
        }

    }
}
