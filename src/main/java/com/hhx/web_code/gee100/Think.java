package com.hhx.web_code.gee100;

/**
 * @author hhx
 * @date 2022/7/19
 * @note
 */
public class Think {

    private static void urlShift() {

        int i = -1;
        System.out.println(Integer.toBinaryString(i));

        i >>>= 10;
        System.out.println(Integer.toBinaryString(i));

        long l = -1;

        System.out.println(Long.toBinaryString(l));

        l >>>= 10;
        System.out.println(Long.toBinaryString(l));

        short s = -1;
        System.out.println(Integer.toBinaryString(s));

        s >>>= 10;
        System.out.println(Integer.toBinaryString(s));


        byte b = -1;
        System.out.println(Integer.toBinaryString(b));

        b >>>= 10;
        System.out.println(Integer.toBinaryString(b));

        b = -1;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b >>> 10));

    }

    public static void main(String[] args) {
        urlShift();
    }
}
