package com.hhx.web_code.springlesson;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Set;

public class MultiValueMapTest {
    public static void main(String[] args) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        // 为name放入3个值
        params.add("name", "Name参数1");
        params.add("name", "Name参数2");
        params.add("name", "Name参数3");
        // 打印第三个参数
        System.out.println(params.get("name").get(2));

        // 打印所有值
        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            List<String> values = ((LinkedMultiValueMap<String, String>) params).get(key);
            for (String value : values) {
                System.out.println(key + ": " + value);
            }
        }

        //要完整接收到所有的 Header，不能直接使用 Map 而应该使用 MultiValueMap
        //方式 1@RequestHeader() MultiValueMap map
    }
    @RequestMapping(path = "/hi2", method = RequestMethod.GET)
    public String hi2(@RequestHeader("MyHeader") String myHeader,
                      @RequestHeader MultiValueMap map){
        return myHeader + " compare with : " + map.get("MyHeader");};
}
