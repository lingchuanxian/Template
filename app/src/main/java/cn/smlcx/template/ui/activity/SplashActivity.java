package cn.smlcx.template.ui.activity;

import android.os.Handler;
import android.widget.ImageView;

import butterknife.BindView;
import cn.smlcx.template.R;
import cn.smlcx.template.base.BaseActivity;
import cn.smlcx.template.base.BasePresenter;
import cn.smlcx.template.utils.ImageLoader;
import cn.smlcx.template.utils.ToActivityUtil;

/**
 * Created by lcx on 2017/6/5.
 */

public class SplashActivity extends BaseActivity {

	@BindView(R.id.iv_splsh)
	ImageView mIvSplsh;

	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_splash;
	}

	@Override
	protected void initViews() {
		mIvSplsh.setImageBitmap(ImageLoader.load(mContext, R.mipmap.splash));
	}

	@Override
	protected BasePresenter initPresenter() {
		return null;
	}

	@Override
	protected void initData() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				ToActivityUtil.toNextActivity(mContext, HomeActivity.class);
				finish();
			}
		}, 3000);
	}
}
