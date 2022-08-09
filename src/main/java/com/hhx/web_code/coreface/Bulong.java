package com.hhx.web_code.coreface;

import cn.hutool.bloomfilter.BitMapBloomFilter;

/**
 * @author hhx
 * @date 2022/8/9
 * @note
 */
public class Bulong {
    public static void main(String[] args) {
        BitMapBloomFilter filter = new BitMapBloomFilter(10);
        filter.add("123");
        filter.add("abc");
        filter.add("ddd");

        // 查找
        boolean flag =    filter.contains("abc");
        System.out.println(flag);
    }
}
