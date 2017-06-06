package cn.smlcx.template.di.module;

import javax.inject.Singleton;

import cn.smlcx.template.api.ApiService;
import cn.smlcx.template.api.RetrofitWrapper;
import dagger.Module;
import dagger.Provides;

/**
 * Created by fjlcx on 6/6/17.
 */
@Module
public class ApiModule {
    @Provides
    @Singleton
    public ApiService provideApiService() {
        return RetrofitWrapper.getInstance().create(ApiService.class);
    }

}
