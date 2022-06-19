package com.hhx.web_code.coreface;

public class StringTest {

    /**
     * 通过字面量的方式创建，abc存储于字符串常量池中；
     */
    String str1= "abc";
    /**
     * 通过new对象的方式创建字符串对象，引用地址存放在堆内存中，
     * abc则存放在字符串常量池中；所以str1 == str2?显然是false
     */
    String str2= new String("abc");
    /**
     * 由于str2调用了intern()方法，会返回常量池中的数据，地址直接指向常量池，
     * 所以str1 == str3；
     * 而str2和str3地址值不等所以也是false（str2指向堆空间，str3直接指向字符串常量池）
     */
    String str3= str2.intern();
}
