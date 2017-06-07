package cn.smlcx.template.di.module;

import android.content.Context;

import javax.inject.Singleton;

import cn.smlcx.template.api.ApiEngine;
import cn.smlcx.template.api.ApiService;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jess on 8/4/16.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return context;
    }

    @Provides
    @Singleton
    public ApiService provideApiService() {
        return ApiEngine.getInstance().getApiService();
    }
}
