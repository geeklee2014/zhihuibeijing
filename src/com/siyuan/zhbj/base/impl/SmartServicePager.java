package com.siyuan.zhbj.base.impl;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.siyuan.zhbj.base.BasePager;

public class SmartServicePager extends BasePager
{

	public SmartServicePager(Activity activity)
	{
		super(activity);
	}
	@Override
	public void initData()
	{
		super.initData();
		
		mTitle.setText("生活");
		
		TextView textview = new TextView(mActivity);
		textview.setText("智慧服务");
		textview.setTextSize(30);
		textview.setTextColor(Color.RED);
		textview.setGravity(Gravity.CENTER);
		flContent.addView(textview);
	}

}
