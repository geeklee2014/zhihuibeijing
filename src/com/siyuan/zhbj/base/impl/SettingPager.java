package com.siyuan.zhbj.base.impl;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.siyuan.zhbj.base.BasePager;

public class SettingPager extends BasePager
{

	public SettingPager(Activity activity)
	{
		super(activity);
	}
	@Override
	public void initData()
	{
		super.initData();
		
		mTitle.setText("…Ë÷√");
		mImageButton.setVisibility(View.GONE);
		
		TextView textview = new TextView(mActivity);
		textview.setText("…Ë÷√");
		textview.setTextSize(30);
		textview.setTextColor(Color.RED);
		textview.setGravity(Gravity.CENTER);
		flContent.addView(textview);
	}

}
