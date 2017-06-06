package cn.smlcx.template.di.component;

import cn.smlcx.template.di.module.NewsModule;
import cn.smlcx.template.ui.activity.HomeActivity;
import dagger.Component;

/**
 * Created by lcx on 6/6/17.
 */
@Component(modules = NewsModule.class)
public interface NewsComponent {
    void inject(HomeActivity activity);
}
