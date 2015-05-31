package com.siyuan.zhbj.fragment;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
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

		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				switch (checkedId)
				{
				case R.id.home:
					mViewPager.setCurrentItem(0);
					break;
				case R.id.news_center:
					mViewPager.setCurrentItem(1);
					break;
				case R.id.smart_service:
					mViewPager.setCurrentItem(2);
					break;
				case R.id.gov_affair:
					mViewPager.setCurrentItem(3);
					break;
				case R.id.setting:
					mViewPager.setCurrentItem(4);
					break;

				default:
					break;
				}
			}
		});

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
			pager.initData();
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
}
