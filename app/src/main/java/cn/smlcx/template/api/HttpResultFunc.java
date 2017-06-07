package cn.smlcx.template.api;

/**
 * Created by lcx on 2017/6/7.
 */

import cn.smlcx.template.bean.HttpResult;
import rx.functions.Func1;

/**
 * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 *
 * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
 */
public class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

	@Override
	public T call(HttpResult<T> httpResult) {
		if (httpResult.getError_code() != 0) {
			throw new ApiException(httpResult.getError_code());
		}
		return httpResult.getResult().getList().get(0);
	}
}
