package com.hhx.web_code.guice;

import cn.hutool.core.io.FileUtil;

/**
 * @author hhx
 * @date 2022/9/4
 * @note
 */
public class FIleDelController {
    public static void main(String[] args) {
        FileUtil.del("D:\\test\\test.txt");
    }
}
