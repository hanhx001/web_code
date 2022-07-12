package com.hhx.web_code.guice;

import com.google.inject.Singleton;

/**
 * @author hhx
 * @date 2022/7/12
 * @note
 */
@Singleton
public class DogImpl implements IAnimal {
    @Override
    public void eat() {
        System.out.println("DogImpl.eat()");
    }

}
