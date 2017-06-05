package cn.smlcx.template.base;

/**
 * Created by lcx on 2017/5/5
 * MVP框架的简单封装 P处理层
 */
public class BasePresenter<M extends BaseModel,V extends BaseView> {
    protected final String TAG = this.getClass().getSimpleName();

    protected M mModel;
    protected V mRootView;


    public BasePresenter(M model, V rootView) {
        this.mModel = model;
        this.mRootView = rootView;
    }

    public BasePresenter(V rootView) {
        this.mRootView = rootView;
    }


}
