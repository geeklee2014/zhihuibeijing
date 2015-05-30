package com.siyuan.zhbj;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.siyuan.zhbj.fragment.ContentFragment;
import com.siyuan.zhbj.fragment.LeftFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends SlidingFragmentActivity
{

	private static final String TAG_LEFT_MENU = "TAG_LEFT_MENU";
	private static final String TAG_CONTENT = "TAG_CONTENT";

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		setBehindContentView(R.layout.left_framelayout);
		SlidingMenu menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT);
        menu.setBehindOffset(450);
		
		initFragment();
	}

	private void initFragment()
	{
		FragmentManager manager = getFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.fl_left_menu, new LeftFragment(), TAG_LEFT_MENU);
		transaction.replace(R.id.fl_content, new ContentFragment(), TAG_CONTENT);
		transaction.commit();
	
	}
}