package cn.smlcx.template.di.module;

import android.content.Context;

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
    public Context getContext() {
        return context;
    }
}
