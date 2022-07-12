package com.hhx.web_code.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * @author hhx
 * @date 2022/7/12
 * @note
 */
public class MainModule extends AbstractModule {
    @Override
    protected void configure() {

        //以上三种方式处理后，使用依赖注入
        // 或者用API injector.getInstance()得到的均会是同一个实例对象，这就是单例了。
        //bind(IAnimal.class).to(DogImpl.class);
       // bind(IAnimal.class).to(CatImpl.class).in(Singleton.class);
        bind(IAnimal.class).toInstance(new DogImpl());
    }
}
