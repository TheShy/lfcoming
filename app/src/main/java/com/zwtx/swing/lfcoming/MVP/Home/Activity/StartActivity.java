package com.zwtx.swing.lfcoming.MVP.Home.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.zwtx.swing.lfcoming.MVP.Base.BaseActivity;
import com.zwtx.swing.lfcoming.MVP.LFHouse.LoginActivity;
import com.zwtx.swing.lfcoming.R;

public class StartActivity extends BaseActivity {

	boolean isFirstIn = false;

	private static final int GO_HOME = 1000;// 主页
	private static final int GO_GUIDE = 1001;// 引导页

	private static final long SPLASH_DELAY_MILLIS = 2000;

	private static final String SHAREDPREFERENCES_NAME = "first_pref";// sharedPreferences名字

	@SuppressLint("HandlerLeak")
	public Handler mhanHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case GO_HOME:
					goLogin();
					break;
				case GO_GUIDE:
					goGuide();
					break;
			}
			super.handleMessage(msg);
		}

	};


	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.vp_start);
		init();
	}

		public void init() {
			SharedPreferences preferences = getSharedPreferences(
					SHAREDPREFERENCES_NAME, MODE_PRIVATE);
			isFirstIn = preferences.getBoolean("isFirstIn", true);
			if (isFirstIn) {
				mhanHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
			} else {
				mhanHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
			}

		}

	@Override
	protected void findViewById() {

	}

	@Override
	protected void setListener() {

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

	}
	private void goLogin() {
		Intent intent = new Intent(StartActivity.this, LoginActivity.class);
		StartActivity.this.startActivity(intent);
		StartActivity.this.finish();
	}

	private void goGuide() {
		Intent intent = new Intent(StartActivity.this, GuideActivity.class);
		StartActivity.this.startActivity(intent);
		StartActivity.this.finish();
	}
}
