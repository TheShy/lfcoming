package com.zwtx.swing.lfcoming.MVP.Home.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.zwtx.swing.lfcoming.MVP.Adapter.ViewPagerAdapter;
import com.zwtx.swing.lfcoming.MVP.LFHouse.LoginActivity;
import com.zwtx.swing.lfcoming.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 引导页
 * 
 * @author huabo
 * 
 */
public class GuideActivity extends FragmentActivity {

	private static final String SHAREDPREFERENCES_NAME = "first_pref";// sharedPreferences名字

	private List<View> viewlist;
	private ViewPager viewpager;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.guide_activity);
		viewlist = new ArrayList<View>();

		View view1 = View.inflate(this, R.layout.vp_first_activity, null);
		View view2 = View.inflate(this, R.layout.vp_second_activity, null);
		View view3 = View.inflate(this, R.layout.vp_thrid_activity, null);
		View view4 = View.inflate(this, R.layout.vp_fourth_activity, null);
		View view5 = View.inflate(this, R.layout.vp_start, null);

		viewlist.add(view1);
		viewlist.add(view2);
		viewlist.add(view3);
		viewlist.add(view4);
		viewlist.add(view5);

		ImageButton start = (ImageButton) view5.findViewById(R.id.start);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				SharedPreferences preferences = getSharedPreferences(
						SHAREDPREFERENCES_NAME, MODE_PRIVATE);
				preferences.edit().putBoolean("isFirstIn", false).commit();

				Intent intent = new Intent(getApplicationContext(),
						LoginActivity.class);
				startActivity(intent);
				finish();

			}
		});
		viewpager = (ViewPager) findViewById(R.id.pager);
		ViewPagerAdapter adapter = new ViewPagerAdapter(viewlist);
		viewpager.setAdapter(adapter);
	}
}