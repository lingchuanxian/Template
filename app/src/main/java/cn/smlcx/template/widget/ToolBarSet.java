package cn.smlcx.template.widget;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by lcx on 2017/6/5.
 */

public class ToolBarSet {
	private Toolbar mToolbar;
	private AppCompatActivity mActivity;
	private ActionBar mActionBar;

	public ToolBarSet(Toolbar toolbar, AppCompatActivity activity) {
		if(toolbar==null){
			return;
		}
		mToolbar = toolbar;
		mActivity = activity;
		activity.setSupportActionBar(mToolbar);
		mActionBar = activity.getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mActivity.finish();
			}
		});
	}

	public ToolBarSet setTitle(String title){
		mActionBar.setTitle(title);
		return this;
	}

	public ToolBarSet setSubtitle(String subTitle){
		mActionBar.setSubtitle(subTitle);
		return this;
	}

	public ToolBarSet setTitle(int resId){
		mActionBar.setTitle(resId);
		return this;
	}

	public ToolBarSet setSubtitle(int resId){
		mActionBar.setSubtitle(resId);
		return this;
	}

	public ToolBarSet setNavigationOnClickListener(View.OnClickListener listener){
		mToolbar.setNavigationOnClickListener(listener);
		return this;
	}

	public ToolBarSet setNavigationIcon(Drawable drawable){
		mToolbar.setNavigationIcon(drawable);
		return this;
	}

	public ToolBarSet setNavigationIcon(int resId){
		mToolbar.setNavigationIcon(resId);
		return this;
	}

	public ToolBarSet setDisplayHomeAsUpEnabled(boolean show){
		mActionBar.setDisplayHomeAsUpEnabled(show);
		return this;
	}

	public ToolBarSet setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener listener){
		mToolbar.setOnMenuItemClickListener(listener);
		return this;
	}

	public void hide(){
		mActionBar.hide();
	}

}
