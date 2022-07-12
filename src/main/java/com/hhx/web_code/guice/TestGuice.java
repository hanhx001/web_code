package com.hhx.web_code.guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author hhx
 * @date 2022/7/12
 * @note
 */
public class TestGuice {
    @Inject
    private IAnimal animal;

    //@Inject
    //public TestGuice(IAnimal animal) {
    //    this.animal = animal;
    //}

    public void fun() {
        Injector inject =  Guice.createInjector(new MainModule());
        inject.injectMembers(this);
        System.out.println(animal);
        System.out.println(inject.getInstance(IAnimal.class));
        System.out.println(inject.getInstance(IAnimal.class));

        animal.eat();
    }
}
