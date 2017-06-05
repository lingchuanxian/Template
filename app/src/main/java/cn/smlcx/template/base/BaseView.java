package cn.smlcx.template.base;

/**
 * Created by Nicholas on 2016/10/30.
 */

public interface BaseView {
    /**
     * 显示进度条
     */
    void showLoding();
    /**
     * 隐藏进度条
     */
    void hideLoding();
    /**
     * 显示加载错误
     * @param err 错误内容
     */
    void showErr(String err);
    /**
     * 显示暂无数据
     * @param msg 提示信息
     */
    void showNonData(String msg);
}