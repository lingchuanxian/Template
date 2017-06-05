package cn.smlcx.template.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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
	protected P mPresenter;
	public Context mContext;
	@Nullable
	@BindView(R.id.toolbar)
	Toolbar mToolbar;
	private ToolBarSet mToolBarSet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(attachLayoutRes());
		ButterKnife.bind(this);
		init();
		initViews();
		mPresenter = initPresenter();
		initData();
	}

	private void init() {
		mContext = this;
		mToolBarSet = new ToolBarSet(mToolbar,this);
	}

	/**
	 * 绑定布局文件
	 *
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
	protected abstract P initPresenter();

	/**
	 * 初始化数据
	 */
	protected abstract void initData();

	public ToolBarSet getToolBar(){
		if(mToolBarSet==null){
			mToolBarSet = new ToolBarSet(mToolbar,this);
		}
		return mToolBarSet;
	}

	@Override
	public void showLoding() {
		if (mEmptyLayout != null) {
			mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_LOADING);
		}
	}

	@Override
	public void hideLoding() {
		if (mEmptyLayout != null) {
			mEmptyLayout.hide();
		}
	}

	@Override
	public void showErr(String err) {
		if (mEmptyLayout != null) {
			mEmptyLayout.setEmptyStatus(EmptyLayout.STATUS_NO_NET);
		}
	}

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

	@Override
	protected void onDestroy() {
		super.onDestroy();

	}

}
