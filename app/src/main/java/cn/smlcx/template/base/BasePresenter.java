package cn.smlcx.template.base;

import javax.inject.Inject;

/**
 * Created by lcx on 2017/5/5
 * MVP框架的简单封装 P处理层
 */
public abstract class BasePresenter<M extends BaseModel,V extends BaseView> {
    protected final String TAG = this.getClass().getSimpleName();
    @Inject
    public M mModel;
    public V mView;

}
