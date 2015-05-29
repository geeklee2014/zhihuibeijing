package com.siyuan.zhbj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;


public class SplashActivity extends Activity {
	private RelativeLayout rlRoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        
        rlRoot = (RelativeLayout) findViewById(R.id.rlRoot);
        
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1500);
        rotate.setFillAfter(true);
        
        ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scale.setDuration(1500);
        scale.setFillAfter(true);
        
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(1500);
        alpha.setFillAfter(true);
       
        AnimationSet set = new AnimationSet(this, null);
        set.addAnimation(alpha);
        set.addAnimation(scale);
        set.addAnimation(rotate);
        
        set.setAnimationListener(new AnimationListener()
		{
			
			@Override
			public void onAnimationStart(Animation animation)
			{
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation)
			{
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation)
			{
				jumpToNext();
			}

			
		});
        
        rlRoot.startAnimation(set);
    }
    private void jumpToNext()
	{
		SharedPreferences sp = getSharedPreferences("zhbj", Context.MODE_PRIVATE);
		boolean isGuideShow = sp.getBoolean("is_guide_show", false);
		if (isGuideShow == false)
			{
				Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
				startActivity(intent);
				finish();
			}
		else
			{
				Intent intent = new Intent(SplashActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		
	}
}
