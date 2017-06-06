package cn.smlcx.template.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import java.util.List;

/**
 * @author smlcx
 * @version 创建时间2016-12-1 下午12:31:48
 *
 */
public class ToActivityUtil {

    /**
     *
     * @Description: 隐式启动,跳转
     * @param packageContext
     * @param action
     *            含操作的Intent
     */
    public static void startActivityIntentSafe(Context packageContext,
            Intent action) {
        // Verify it resolves
        PackageManager packageManager = packageContext.getPackageManager();
        List activities = packageManager.queryIntentActivities(action,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it'PresenterContract safe
        if (isIntentSafe) {
            packageContext.startActivity(action);
        }

    }

    /**
     * @Description: 跳转
     * @param packageContext
     *            from,般传XXXActivity.this
     * @param cls
     *            to,般传XXXActivity.class
     */
    public static void toNextActivity(Context packageContext, Class<?> cls) {
        Intent i = new Intent(packageContext, cls);
        packageContext.startActivity(i);
    }

    /**
     * @Description: 跳转,带参数的方法;要其它的数据类型,再继续重载吧
     * @param packageContext
     * @param cls
     * @param keyvalues  要传进去的String参数{{key1,values},{key2,value2}...}
     */
    public static void toNextActivity(Context packageContext, Class<?> cls,
									  String[][] keyvalues) {
        Intent i = new Intent(packageContext, cls);
        for (String[] strings : keyvalues) {
            i.putExtra(strings[0], strings[1]);
        }
        packageContext.startActivity(i);
    }

    public static void toNextActivityAndFinish(Context packageContext,
            Class<?> cls) {
        Intent i = new Intent(packageContext, cls);
        packageContext.startActivity(i);

        ((Activity) packageContext).finish();
    }

    public static void finish(Activity activity) {
        activity.finish();
    }
}