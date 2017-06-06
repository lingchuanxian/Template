package cn.smlcx.template.di.module;

import cn.smlcx.template.mvp.model.NewsListModel;
import cn.smlcx.template.mvp.presenter.NewsListPresenter;
import cn.smlcx.template.mvp.view.ViewContract;
import dagger.Module;
import dagger.Provides;

/**
 * Created by fjlcx on 6/6/17.
 */
@Module
public class NewsModule {
    private ViewContract.NewsListView mView;

    public NewsModule(ViewContract.NewsListView view) {
        this.mView = view;
    }
    @Provides
    public NewsListPresenter getNewsListPresenter(NewsListModel model){
        return new NewsListPresenter(model,mView);
    }

    @Provides
    public NewsListModel getNewsListModel(){
        return new NewsListModel();
    }

}
