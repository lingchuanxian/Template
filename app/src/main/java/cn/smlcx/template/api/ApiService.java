package cn.smlcx.template.api;

/**
 * Created by lcx on 2017/5/4.
 */

public interface ApiService {
    /**
     * 获取5-7天的天气情况
     * @param app  接口 此处应为:weather.future
     * @param weaid 城市气象编号，可以是beijing(拼音)/北京(城市名)/1(NowAPI定义的编号*推荐)/101010100(气象局编号)/202.104.153.201(ip地址)
     * @param appkey 使用API的唯一凭证
     * @param sign md5后的32位密文
     * @param format 返回数据格式（json|xml）
     * @return
     *//*
    @GET("/")
    Observable<WeatherBean> getWeather(@Query("app") String app, @Query("weaid") String weaid, @Query("appkey") String appkey, @Query("sign") String sign, @Query("format") String format);*/

}
