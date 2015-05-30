package com.siyuan.zhbj.fragment;

import com.siyuan.zhbj.R;

import android.view.View;

public class ContentFragment extends BaseFragment
{

	@Override
	public View initView()
	{
		View view = View.inflate(mActivity, R.layout.fragment_content, null);
		return view;
	}

}
