package cn.smlcx.template.global;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import cat.ereza.customactivityoncrash.config.CaocConfig;
import cn.smlcx.template.di.component.AppComponent;
import cn.smlcx.template.di.component.DaggerAppComponent;
import cn.smlcx.template.di.module.AppModule;

/**
 * Created by lcx on 2017/6/5.
 */

public class TemplateApplication extends Application {
	private static TemplateApplication instance;
	private ActivityManager activityManager = null; // activity管理类
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		//内存溢出检测
		LeakCanary.install(this);
		getAppComponent();
		activityManager = ActivityManager.getInstance(); // 获得实例

		//全局异常处理
		CaocConfig.Builder.create()
				.backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //default: CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM
				.enabled(true) //default: true
				.showErrorDetails(true) //default: true
				.showRestartButton(true) //default: true
				.trackActivities(false) //default: false
				.minTimeBetweenCrashesMs(2000) //default: 3000
				/*.errorDrawable(R.drawable.ic_custom_drawable) //default: bug image
				.restartActivity(YourCustomActivity.class) //default: null (your app's launch activity)*/
				//.errorActivity(ErrorActivity.class) //default: null (default error activity)
				//.eventListener(new YourCustomEventListener()) //default: null*
				.apply();
	}

	public static TemplateApplication getInstance() {
		return instance;
	}

	public ActivityManager getActivityManager() {
		return activityManager;
	}

	// 初始化dagger2
	public AppComponent getAppComponent(){
		return DaggerAppComponent.builder()
				.appModule(new AppModule(this))
				.build();
	}
}
