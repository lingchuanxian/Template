package cn.smlcx.template.mvp.model;

import javax.inject.Inject;

import cn.smlcx.template.api.ApiEngine;
import cn.smlcx.template.base.BaseModel;
import cn.smlcx.template.bean.News;
import cn.smlcx.template.bean.ResponseResult;
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

	public Observable<ResponseResult<News>> getNewsListModel(int pno, int ps, String key, String dtype){
		return ApiEngine.getInstance().getApiService().getNewsList(pno,ps,key,dtype);
	}
}
