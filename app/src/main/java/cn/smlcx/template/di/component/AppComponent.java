package cn.smlcx.template.di.component;

import android.content.Context;

import javax.inject.Singleton;

import cn.smlcx.template.api.ApiService;
import cn.smlcx.template.di.module.ApiModule;
import cn.smlcx.template.di.module.AppModule;
import dagger.Component;

/**
 * Created by lcx on 6/6/17.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    Context getContext();
    ApiService getApiService();
}
