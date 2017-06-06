package cn.smlcx.template.mvp.view;

import java.util.List;

import cn.smlcx.template.base.BaseView;

/**
 * Created by lcx on 2017/6/5.
 */

public interface ViewContract {
	interface NewsListView extends BaseView {
		void success(List<?> list);
		void fail(String msg);
	}
}
