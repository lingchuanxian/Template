package cn.smlcx.universal.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/4/16.
 */
public class ToastUtil {

    private ToastUtil()
    {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     *
     * @param context
     * @param msg 要显示的信息字符
     */
    public static void show(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * @param context
     * @param msgResId 要显示的信息字符串在R文件中的id
     */
    public static void show(Context context, int msgResId){
        Toast.makeText(context,msgResId, Toast.LENGTH_SHORT).show();
    }



    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message) {
        Toast toast=null;
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }


    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showshort(Context context, CharSequence message) {
        Toast toast=null;
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

}
