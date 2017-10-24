package com.zwtx.swing.lfcoming.MVP.LFHouse;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zwtx.swing.lfcoming.Data.Api.HttpApi;
import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.R;
import com.zwtx.swing.lfcoming.Utils.FoToast;
import com.zwtx.swing.lfcoming.Utils.UrlHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import okhttp3.Call;

/**
 * 注册页面
 */

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.register_et_phone)
    EditText et_phone;
    @BindView(R.id.register_et_code)
    EditText et_code;

    @BindView(R.id.register_btn_getcode)
    Button btn_getcode;
    @BindView(R.id.register_btn_next)
    Button btn_next;

    /**
     * 保存手机号
     */
    private String userPhone;
    /**
     * 验证码
     */
    private String authCode;
    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_register);

    }

    @Override
    protected void findViewById() {
        btn_getcode= (Button) findViewById(R.id.register_btn_getcode);
        btn_next= (Button) findViewById(R.id.register_btn_next);

    }

    @Override
    protected void setListener() {
        btn_next.setOnClickListener(this);
        btn_getcode.setOnClickListener(this);
        setTitleLeftBtn();
        setTitleName(R.string.become_lf);

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
            case R.id.register_btn_next:

                break;
            case R.id.register_btn_getcode:
                if (TextUtils.isEmpty(userPhone)){
                    FoToast.showToast("手机号不能为空");
                    return;
                }
                if (!isTurePhone(userPhone)) {
                    FoToast.showToast("请输入正确的手机号");
                    return;
                }
                requestAuthCode(userPhone);
                break;
        }

    }

    /**
     * 获取短信验证码
     */
    private void requestAuthCode(String phoneNumber) {
        //参数集合
        Map<String, String> map = new HashMap<String, String>();
        map.put("mobile", phoneNumber);
        OkHttpUtils.post()
                .url(HttpApi.ROOT_PATH+HttpApi.USER_SEND_MESSAGE)
                .params(UrlHelper.getInstance().getBaseParams(map))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String code = jsonObject.getString("code");
                            if ("1".equals(code)) {
                                FoToast.toast(mContext, jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                });
    }

    //判断手机号格式
    public boolean isTurePhone(String phoneNum) {
        if (phoneNum.length() == 11 && phoneNum.startsWith("1")) {
            return true;
        } else {
            return false;
        }
    }
}
