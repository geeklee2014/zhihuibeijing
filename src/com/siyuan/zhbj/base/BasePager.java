package com.siyuan.zhbj.base;

import com.siyuan.zhbj.R;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class BasePager
{
	public Activity mActivity;
	public View mRootView;
	public TextView mTitle;
	public ImageButton mImageButton;
	public FrameLayout flContent;
	
	public BasePager(Activity activity)
	{
		mActivity = activity;
		mRootView = initView();
		
	} 
	public View initView()
	{
		View view = View.inflate(mActivity, R.layout.base_pager, null);
		mTitle = (TextView) view.findViewById(R.id.title);
		mImageButton = (ImageButton) view.findViewById(R.id.btn_menu);
		flContent = (FrameLayout) view.findViewById(R.id.fl_content);
		return view;
	}
	public void initData()
	{
		
	}
}
