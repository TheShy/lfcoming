package com.zwtx.swing.lfcoming.MVP.Home.MyStudyLF;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zaaach.citypicker.CityPickerActivity;
import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;

import butterknife.BindView;

/**
 * 我学雷锋
 */

public class MyStudyLFActivity extends BaseActivity {


    @BindView(R.id.my_study_btn_city)
    Button btn_city;

    @BindView(R.id.my_study_iv_skills)
    ImageView iv_skills;
    private static final int REQUEST_CODE_PICK_CITY = 0;//启动

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_mystudy);

    }

    @Override
    protected void findViewById() {
        iv_skills = (ImageView) findViewById(R.id.my_study_iv_skills);
        btn_city = (Button) findViewById(R.id.my_study_btn_city);
    }

    @Override
    protected void setListener() {
        iv_skills.setOnClickListener(this);
        btn_city.setOnClickListener(this);

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
            case R.id.my_study_btn_city:
                startActivityForResult(new Intent(this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;

            case R.id.my_study_iv_skills:
                mIntent = new Intent(this, MySkillActivity.class);
                startActivity(mIntent);
                break;
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                btn_city.setText(  city);
            }
        }

    }

}
