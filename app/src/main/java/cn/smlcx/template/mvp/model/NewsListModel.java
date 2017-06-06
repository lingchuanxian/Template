package cn.smlcx.template.mvp.model;

import javax.inject.Inject;

import cn.smlcx.template.api.ApiService;
import cn.smlcx.template.api.RetrofitWrapper;
import cn.smlcx.template.base.BaseModel;
import cn.smlcx.template.bean.News;
import cn.smlcx.template.di.scope.ActivityScope;
import rx.Observable;

/**
 * Created by lcx on 2017/6/5.
 */
@ActivityScope
public class NewsListModel implements BaseModel{
	private ApiService mApiService;
	@Inject
	public NewsListModel() {
		if(mApiService==null){
			this.mApiService = RetrofitWrapper.getInstance().create(ApiService.class);
		}
	}

	public Observable<News> getNewsListModel(int pno, int ps, String key, String dtype){
		return mApiService.getNewsList(pno,ps,key,dtype);
	}

	@Override
	public void onFailed(String error) {

	}
}
