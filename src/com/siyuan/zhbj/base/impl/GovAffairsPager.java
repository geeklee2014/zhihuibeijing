package com.siyuan.zhbj.base.impl;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.siyuan.zhbj.base.BasePager;

public class GovAffairsPager extends BasePager
{

	public GovAffairsPager(Activity activity)
	{
		super(activity);
	}
	@Override
	public void initData()
	{
		super.initData();
		TextView textview = new TextView(mActivity);
		textview.setText("ÕþÎñ");
		textview.setTextSize(30);
		textview.setTextColor(Color.RED);
		textview.setGravity(Gravity.CENTER);
		flContent.addView(textview);
	}

}
