package com.siyuan.zhbj.fragment;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.siyuan.zhbj.MainActivity;
import com.siyuan.zhbj.R;
import com.siyuan.zhbj.base.BasePager;
import com.siyuan.zhbj.base.impl.GovAffairsPager;
import com.siyuan.zhbj.base.impl.HomePager;
import com.siyuan.zhbj.base.impl.NewsCenterPager;
import com.siyuan.zhbj.base.impl.SettingPager;
import com.siyuan.zhbj.base.impl.SmartServicePager;
import com.siyuan.zhbj.view.NoScrollViewPager;

public class ContentFragment extends BaseFragment
{
	@ViewInject(R.id.vp_content)
	private NoScrollViewPager mViewPager;
	@ViewInject(R.id.radioGroup)
	private RadioGroup radioGroup;

	private ArrayList<BasePager> mPagers;

	@Override
	public View initView()
	{
		View view = View.inflate(mActivity, R.layout.fragment_content, null);
		ViewUtils.inject(this, view);// ×¢Èë
		return view;
	}

	@Override
	public void initData()
	{
		super.initData();
		mPagers = new ArrayList<BasePager>();
		mPagers.add(new HomePager(mActivity));
		mPagers.add(new NewsCenterPager(mActivity));
		mPagers.add(new SmartServicePager(mActivity));
		mPagers.add(new GovAffairsPager(mActivity));
		mPagers.add(new SettingPager(mActivity));

		ContentAdapter adapter = new ContentAdapter();
		mViewPager.setAdapter(adapter);
		
		// check the homePager default
		radioGroup.check(R.id.home);

		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				switch (checkedId)
				{
				case R.id.home:
					mViewPager.setCurrentItem(0);
					mPagers.get(0).initData();
					break;
				case R.id.news_center:
					mViewPager.setCurrentItem(1);
					mPagers.get(1).initData();
					break;
				case R.id.smart_service:
					mViewPager.setCurrentItem(2);
					mPagers.get(2).initData();
					break;
				case R.id.gov_affair:
					mViewPager.setCurrentItem(3);
					mPagers.get(3).initData();
					break;
				case R.id.setting:
					mViewPager.setCurrentItem(4);
					mPagers.get(4).initData();
					break;

				default:
					break;
				}
			}
		});
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener()
		{
			
			@Override
			public void onPageSelected(int position)
			{
				if (position == 0 || position == 4)
					{
						setSlidingMenuEnable(false);
					}
				else
					{
						setSlidingMenuEnable(true);
					}
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels)
			{
				
			}
			
			@Override
			public void onPageScrollStateChanged(int state)
			{
				
			}
		});
		
		mPagers.get(0).initData();
		setSlidingMenuEnable(false);
	}

	class ContentAdapter extends PagerAdapter
	{

		@Override
		public int getCount()
		{
			return mPagers.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object)
		{
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position)
		{
			BasePager pager = mPagers.get(position);
			// pager.initData();
			View view = pager.mRootView;
			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			container.removeView((View) object);
		}
	}
	private void setSlidingMenuEnable(boolean b)
	{
		MainActivity main = (MainActivity) mActivity;
		SlidingMenu menu = main.getSlidingMenu();
		if (b == false)
			{
				menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
			}
		else
			{
				menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
			}
	}
}
