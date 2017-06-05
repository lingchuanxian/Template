package cn.smlcx.template.ui.activity;

import cn.smlcx.template.R;
import cn.smlcx.template.base.BaseActivity;
import cn.smlcx.template.base.BasePresenter;

/**
 * Created by lcx on 2017/6/5.
 */

public class HomeActivity extends BaseActivity {
	protected final String TAG = this.getClass().getSimpleName();
	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_home;
	}

	@Override
	protected void initViews() {
		getToolBar().setTitle("首页")
				.setDisplayHomeAsUpEnabled(false);
	}

	@Override
	protected BasePresenter initPresenter() {
		return null;
	}

	@Override
	protected void initData() {

	}
}
