package cn.smlcx.template.mvp.model;

import javax.inject.Inject;

import cn.smlcx.template.api.ApiEngine;
import cn.smlcx.template.base.BaseModel;
import cn.smlcx.template.bean.HttpResult;
import cn.smlcx.template.bean.News;
import cn.smlcx.template.di.scope.ActivityScope;
import rx.Observable;

/**
 * Created by lcx on 2017/6/5.
 */
@ActivityScope
public class NewsListModel implements BaseModel{
	@Inject
	public NewsListModel() {
	}

	public Observable<HttpResult<News>> getNewsListModel(int pno, int ps, String key, String dtype){
		return ApiEngine.getInstance().getApiService().getNewsList(pno,ps,key,dtype);
				//.compose(RxHelper.<HttpResult<News>>handleResult());
	}
}
