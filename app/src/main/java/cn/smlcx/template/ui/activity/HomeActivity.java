package cn.smlcx.template.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.smlcx.template.R;
import cn.smlcx.template.base.BaseActivity;
import cn.smlcx.template.bean.News;
import cn.smlcx.template.di.component.DaggerNewsComponent;
import cn.smlcx.template.di.module.NewsModule;
import cn.smlcx.template.global.TemplateApplication;
import cn.smlcx.template.mvp.presenter.NewsListPresenter;
import cn.smlcx.template.mvp.view.ViewContract;
import cn.smlcx.template.ui.adapter.NewsListAdapter;

/**
 * Created by lcx on 2017/6/5.
 */

public class HomeActivity extends BaseActivity<NewsListPresenter> implements ViewContract.NewsListView{
	protected final String TAG = this.getClass().getSimpleName();
	@BindView(R.id.rlv_news)
	RecyclerView mRlvNews;
	@BindView(R.id.swiperefresh)
	SwipeRefreshLayout mSwiperefresh;
	private NewsListAdapter mAdapter;
	private List<News> mDatas = new ArrayList<News>();
	private int mCurrentPage = 1;//当前页码
	private int mTotalPage;//总页码
	private int flag = 0;//0 -- 第一次加载或者刷新  1 -- 加载更多
	@Override
	protected int attachLayoutRes() {
		return R.layout.activity_home;
	}

	@Override
	protected void initViews() {
		/* 设置toolBar */
		getToolBar().setTitle("微信精选")
				.setDisplayHomeAsUpEnabled(false)
				.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						switch (item.getItemId()) {
							case R.id.action_add:
								new MaterialDialog.Builder(mContext)
										.title("退出")
										.content("您确定要退出吗？")
										.positiveText("确定")
										.onPositive(new MaterialDialog.SingleButtonCallback() {
											@Override
											public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
												TemplateApplication.getInstance().getActivityManager().finishAllActivity();
											}
										})
										.negativeText("取消")
										.onNegative(new MaterialDialog.SingleButtonCallback() {
											@Override
											public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
												dialog.dismiss();
											}
										})
										.cancelable(false)
										.show();
								break;
						}
						return false;
					}
				});
		mAdapter = new NewsListAdapter(mDatas);
		mRlvNews.setAdapter(mAdapter);
		/* item点击事件 */
		mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
				Intent intent = new Intent(HomeActivity.this,NewsDetailActivity.class);
				intent.putExtra("url",mDatas.get(position).getUrl());
				intent.putExtra("title",mDatas.get(position).getTitle());
				startActivity(intent);
			}
		});
		/* 刷新操作 */
		mSwiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				flag = 0;
				mCurrentPage = 1;
				mPresenter.getNewsList(mCurrentPage, false);
			}
		});
		/* 加载更多 */
		mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
			@Override public void onLoadMoreRequested() {
				mRlvNews.postDelayed(new Runnable() {
					@Override
					public void run() {
						if (mCurrentPage >= mTotalPage) {//数据全部加载完毕
							mAdapter.loadMoreEnd();
						} else {//数据未加载完，继续请求加载
							flag = 1;
							mCurrentPage += 1;
							mPresenter.getNewsList(mCurrentPage,false);
						}
					}
				}, 1000);
			}
		});
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
		mPresenter.getNewsList(mCurrentPage, true);
	}

	@Override
	public void success(int totalPage,List<?> list) {
		//获取页码
		mTotalPage = totalPage;
		if(flag == 0){//第一次加载或者刷新
			mDatas.clear();
			if(list.size() == 0){
				showNonData("当前暂无数据。");
				return;
			}
			mSwiperefresh.setRefreshing(false);
		}else if(flag == 1){//加载更多
			mAdapter.loadMoreComplete();
		}
		mAdapter.addData((List<News>)list);
	}

	@Override
	public void fail(String msg) {
		showErr(msg);
	}

	/** 创建菜单 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main,menu);
		return true;
	}

	/* 按返回键后台运行程序 */
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addCategory(Intent.CATEGORY_HOME);
		startActivity(intent);
	}
}
