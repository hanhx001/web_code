package com.hhx.web_code.guice;

/**
 * @author hhx
 * @date 2022/7/12
 * @note
 */
public class CatImpl implements IAnimal {
    @Override
    public void eat() {
        System.out.println("CatImpl.eat()");
    }

}
