package com.zwtx.swing.lfcoming.MVP.Base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.zwtx.swing.lfcoming.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/19/019.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected Context mContext;
    private ConnectivityManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 锁定竖屏
        mContext = getActivityContext();
        initView();
        ButterKnife.bind(this);
        initdata();
//        MyApplication.getInstance().addActivity(this);
    }

    private void initView() {
        loadViewLayout();

    }

    private void initdata() {
        findViewById();
        setListener();
        processLogic();
    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
//		StatService.onPause(mContext);
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
//		StatService.onResume(mContext);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
//        MyApplication.getInstance().finishActivity(this);
    }
    /**
     * 加载页面layout
     */
    protected abstract void loadViewLayout();

    /**
     * 加载页面元素
     */
    protected abstract void findViewById();

    /**
     * 设置各种事件的监听器
     */
    protected abstract void setListener();

    /**
     * 业务逻辑处理，主要与后端交互
     */
    protected abstract void processLogic();


    /**
     * Activity.this
     */
    protected abstract Context getActivityContext();
    /**
     * 标题左键
     */
    protected void setTitleLeftBtn() {
        ImageView iv = (ImageView) this.findViewById(R.id.iv_title_back);
        if (null == iv) {
            return;
        }
//        iv.setBackgroundResource(R.drawable.back_btn);
        iv.setImageResource(R.mipmap.back);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    /**
     * 设置页面标题名称
     */
    protected void setTitleName(int rId) {
        TextView textView = (TextView) this.findViewById(R.id.tv_title_txt);
        if (null == textView) {
            return;
        }

        textView.setText(rId);
    }

    /**
     * 获取屏幕宽度(px)
     *
     * @param
     * @return
     */
    public int getMobileWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        return width;
    }

    /**
     * 获取屏幕高度(px)
     *
     * @param
     * @return
     */
    public int getMobileHeight() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        return height;
    }

    /**
     * 获取状态栏高度
     * @return
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    /*
	返回版本api
	 */
    public boolean SdkApi(){
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.KITKAT){
            return true;
        } else{
            return false;
        }
    }
    public boolean checkNetworkState() {
        boolean flag = false;
        //得到网络连接信息
        manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        return flag;
    }
    public String getVersionName()
    {
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(),0);
            String version = packInfo.versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "1.0";
    }

}
