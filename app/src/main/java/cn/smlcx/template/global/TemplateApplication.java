package cn.smlcx.template.global;

import android.app.Application;

import cn.smlcx.template.di.component.DaggerAppComponent;
import cn.smlcx.template.di.module.ApiModule;
import cn.smlcx.template.di.module.AppModule;

/**
 * Created by lcx on 2017/6/5.
 */

public class TemplateApplication extends Application {
	private static TemplateApplication instance;
	private String sign = "123";
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		DaggerAppComponent.builder()
				.appModule(new AppModule(this))
				.apiModule(new ApiModule())
				.build();
	}

	public static TemplateApplication getInstance() {
		return instance;
	}
}
