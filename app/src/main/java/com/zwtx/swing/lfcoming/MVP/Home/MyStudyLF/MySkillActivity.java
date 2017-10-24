package com.zwtx.swing.lfcoming.MVP.Home.MyStudyLF;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import butterknife.BindView;

/**
 * 我的技能
 */

public class MySkillActivity extends BaseActivity {

    @BindView(R.id.my_study_btn_recost)
    Button btn_cost;
    @BindView(R.id.my_study_btn_finsh)
    Button btn_finsh;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_skills);


    }

    @Override
    protected void findViewById() {
        btn_cost= (Button) findViewById(R.id.my_study_btn_recost);
        btn_finsh= (Button) findViewById(R.id.my_study_btn_finsh);

    }

    @Override
    protected void setListener() {
        btn_cost.setOnClickListener(this);
        btn_finsh.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.my_skills);
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
            case R.id.my_study_btn_recost:
                finish();
                break;

            case R.id.my_study_btn_finsh:
                finish();
                break;
        }

    }


}
