package cn.smlcx.template.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.smlcx.template.R;
import cn.smlcx.template.base.BaseActivity;
import cn.smlcx.template.bean.News;
import cn.smlcx.template.di.component.DaggerNewsComponent;
import cn.smlcx.template.di.module.NewsModule;
import cn.smlcx.template.mvp.presenter.NewsListPresenter;
import cn.smlcx.template.mvp.view.ViewContract;
import cn.smlcx.template.ui.adapter.NewsListAdapter;

/**
 * Created by lcx on 2017/6/5.
 */

public class HomeActivity extends BaseActivity<NewsListPresenter> implements ViewContract.NewsListView {
	protected final String TAG = this.getClass().getSimpleName();
	@BindView(R.id.rlv_news)
	RecyclerView mRlvNews;
	@BindView(R.id.swiperefresh)
	SwipeRefreshLayout mSwiperefresh;
	private NewsListAdapter mAdapter;
	private List<News> mDatas = new ArrayList<News>();
	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_home;
	}

	@Override
	protected void initViews() {
		getToolBar().setTitle("首页")
				.setDisplayHomeAsUpEnabled(false);
		mAdapter = new NewsListAdapter(mDatas);
		mRlvNews.setAdapter(mAdapter);
	}

	@Override
	protected void initInject() {
		DaggerNewsComponent.builder()
				.newsModule(new NewsModule(this))
				.build()
				.inject(this);
	}

	@Override
	protected void initData() {
		mPresenter.getNewsList(1, 50, "d975b5fe029c0691fe5d683cb68b86ac", "json");
	}


	@Override
	public void success(List<?> list) {
		mDatas.addAll((List<News>)list);
		mAdapter.notifyDataSetChanged();
	}

	@Override
	public void fail(String msg) {
		showErr(msg);
	}
}
