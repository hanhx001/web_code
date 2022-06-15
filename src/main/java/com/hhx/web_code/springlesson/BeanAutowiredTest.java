package com.hhx.web_code.springlesson;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanAutowiredTest {
    /** 方案一：
     * 注入的bean，如果有多个实现，选择顺序
     * 1. @Primary
     * 2、@Priority
     */

    /**
     * 方案二：
     * @Autowired()
     * @Qualifier("") //通过注解指定bean的名称,注意此处要bean的首字母小写
     */

    /**
     * 如果一个类名是以两个大写字母开头的，则首字母不变，其它情况下默认首字母变成小写。
     * 结合我们之前的案例，SQLiteDataService 的 Bean，其名称应该就是类名本身，
     * 而 CassandraDataService 的 Bean 名称则变成了首字母小写（cassandraDataService）。
     */

    /**
     * @Component 表明一个类会作为组件类，并告诉Spring要为这个类创建bean，通常是通过类路径扫描来自动侦测
     *  以及自动装配到Sprinig容器中。
     * @Bean 注解告诉Spring这个方法将会返回一个对象，这个对象要注册为Spring应用上下文中的bean
     *  通常是我们子啊标有该注解的方法中定义产生这个bean的逻辑
     *  当应用第三方库中的类需要装配到Spring中时，智能通过@Bean来实现
     */




}
