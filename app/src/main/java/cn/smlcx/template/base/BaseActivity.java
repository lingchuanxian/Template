package cn.smlcx.template.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.smlcx.template.R;
import cn.smlcx.template.widget.EmptyLayout;
import cn.smlcx.template.widget.ToolBarSet;


/**
 * Created by lcx on 2017/5/4.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
	@Nullable
	@BindView(R.id.empty_layout)
	EmptyLayout mEmptyLayout;
	@Nullable
	@BindView(R.id.toolbar)
	Toolbar mToolbar;

	@Inject
	protected P mPresenter;
	public Context mContext;
	private ToolBarSet mToolBarSet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(attachLayoutRes());
		ButterKnife.bind(this);
		init();
	}

	private void init() {
		mContext = this;
		mToolBarSet = new ToolBarSet(mToolbar,this);
		initInject();
		initViews();
		initPresenter();
		initData();
	}

	/**
	 * 绑定布局文件
	 * @return 布局文件ID
	 */
	@LayoutRes
	protected abstract int attachLayoutRes();

	/**
	 * 初始化视图控件
	 */
	protected abstract void initViews();

	/**
	 * 初始化presenter
	 */
	protected abstract void initPresenter();

	/**
	 * 初始化数据
	 */
	protected abstract void initData();

	/**
	 * 初始化dagger2
	 */
	protected abstract void initInject();

	/**
	 * 获取Toolbar对象
	 * @return
	 */
	public ToolBarSet getToolBar(){
		if(mToolBarSet==null){
			mToolBarSet = new ToolBarSet(mToolbar,this);
		}
		return mToolBarSet;
	}

	/**
	 * 加载中
	 */
	@Override
	public void showLoding() {
		if (mEmptyLayout != null) {
			mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_LOADING);
		}
	}
	/**
	 * 隐藏加载
	 */
	@Override
	public void hideLoding() {
		if (mEmptyLayout != null) {
			mEmptyLayout.hide();
		}
	}

	/**
	 * 显示错误信息
	 */
	@Override
	public void showErr(String err) {
		if (mEmptyLayout != null) {
			mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_NO_NET);
		}
	}
	/**
	 * 无数据
	 */
	@Override
	public void showNonData(String msg) {
		if (mEmptyLayout != null) {
			mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_NO_DATA);
		}
	}

	/*设置activity之间的切换动画*/
	/*@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(R.anim.slide_right_entry, R.anim.hold);
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(R.anim.hold, R.anim.slide_right_exit);
	}
	*/

	/**
	 * 页面跳转
	 * @param clz
	 */
	protected void startActivity(Class<?> clz) {
		startActivity(new Intent(BaseActivity.this,clz));
	}

	/**
	 * 携带数据的页面跳转
	 * @param clz
	 * @param bundle
	 */
	protected void startActivity(Class<?> clz, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(this, clz);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

	/**
	 * 简化Toast
	 * @param msg
	 */
	protected void showToast(String msg){
		Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
