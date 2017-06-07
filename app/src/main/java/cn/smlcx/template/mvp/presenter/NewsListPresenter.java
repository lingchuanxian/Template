package cn.smlcx.template.mvp.presenter;

import android.util.Log;

import javax.inject.Inject;

import cn.smlcx.template.base.BasePresenter;
import cn.smlcx.template.bean.HttpResult;
import cn.smlcx.template.bean.News;
import cn.smlcx.template.di.scope.ActivityScope;
import cn.smlcx.template.mvp.model.NewsListModel;
import cn.smlcx.template.mvp.view.ViewContract;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by lcx on 2017/6/6.
 */
@ActivityScope
public class NewsListPresenter extends BasePresenter<NewsListModel,ViewContract.NewsListView>{

	@Inject
	public NewsListPresenter(NewsListModel model,ViewContract.NewsListView view) {
		this.mModel = model;
		this.mView = view;
	}

	public void getNewsList(int pno, int ps, String key, String dtype) {
		mModel.getNewsListModel(pno,ps,key,dtype)
				.subscribeOn(Schedulers.newThread())//请求在新的线程中执行
				.observeOn(Schedulers.io())         //请求完成后在io线程中执行
				.doOnSubscribe(new Action0() {
					@Override
					public void call() {
					}
				})
				.observeOn(AndroidSchedulers.mainThread())//最后在主线程中执行
				.subscribe(new Subscriber<HttpResult<News>>() {
					@Override
					public void onCompleted() {
					}
					@Override
					public void onError(Throwable e) {
					}
					@Override
					public void onNext(HttpResult<News> result) {
						Log.d(TAG, "onNext: "+result.getResult().getList().size());
					}
				});;
	}
}
