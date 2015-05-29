package com.siyuan.zhbj;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class GuideActivity extends Activity
{
	private ViewPager viewPagerGuide;
	private Button btnStart;
	private int[] mGuidePic = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
	private ArrayList<ImageView> viewPagerList;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_guide);
		
		initView();
		initData();
		
		GuideAdapter adapter = new GuideAdapter();
		viewPagerGuide.setAdapter(adapter);
		viewPagerGuide.setOnPageChangeListener(adapter);
		btnStart.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				SharedPreferences sp = getSharedPreferences("zhbj", Context.MODE_PRIVATE);
				sp.edit().putBoolean("is_guide_show", true).commit();
				Intent intent = new Intent(GuideActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}
	private void initData()
	{
		//初始化引导图片数据
		viewPagerList = new ArrayList<ImageView>();
		for (int i = 0; i < mGuidePic.length; i++)
			{
				ImageView image = new ImageView(this);
				image.setBackgroundResource(mGuidePic[i]);
				viewPagerList.add(image);
			}
		
	}
	private void initView()
	{
		viewPagerGuide = (ViewPager) findViewById(R.id.viewPagerGuide);
		btnStart = (Button) findViewById(R.id.btnStart);
	}
	class GuideAdapter extends PagerAdapter implements OnPageChangeListener
	{

		@Override
		public int getCount()
		{
			return viewPagerList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1)
		{
			return arg0 == arg1;
		}
		//初始化界面数据
		@Override
		public Object instantiateItem(ViewGroup container, int position)
		{
			ImageView imageView = viewPagerList.get(position);
			container.addView(imageView);
			
			return imageView;
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			container.removeView((View) object);
		}

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels)
		{
			
		}

		@Override
		public void onPageSelected(int position)
		{
			Log.d("GuideActivity", position + "");
			if (position == mGuidePic.length - 1)
				{
					btnStart.setVisibility(View.VISIBLE);
				}
		}

		@Override
		public void onPageScrollStateChanged(int state)
		{
			
		}
		
	}
}
