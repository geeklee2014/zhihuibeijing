package com.siyuan.zhbj.base.impl;

import android.app.Activity;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.siyuan.zhbj.base.BasePager;
import com.siyuan.zhbj.domain.NewsBean;
import com.siyuan.zhbj.utils.GlobalConstants;

public class NewsCenterPager extends BasePager
{

	public NewsCenterPager(Activity activity)
	{
		super(activity);
	}
	@Override
	public void initData()
	{
		super.initData();
		
		mTitle.setText("新闻中心");
		
		getDataFromNet();
		
	}
	private void getDataFromNet()
	{
		HttpUtils utils = new HttpUtils();
		utils.send(HttpMethod.GET, GlobalConstants.NEWS_URL, new RequestCallBack<String>()
		{

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo)
			{
				String result = responseInfo.result;
//				System.out.println(result);
				processData(result);
			}

			

			@Override
			public void onFailure(HttpException error, String msg)
			{
				
			}
		});
	}
	private void processData(String result)
	{
		Gson gson = new Gson();
		NewsBean newsBean = gson.fromJson(result, NewsBean.class);
		System.out.println(newsBean);
	}

}
