package cn.smlcx.template.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.smlcx.template.R;
import cn.smlcx.template.bean.News;

/**
 * Created by lcx on 2017/6/8.
 */

public class NewsListAdapter extends BaseQuickAdapter<News,BaseViewHolder> {

	public NewsListAdapter(@Nullable List data) {
		super(R.layout.item_news, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, News item) {
		helper.setText(R.id.tv_title, item.getTitle());
	}
}
