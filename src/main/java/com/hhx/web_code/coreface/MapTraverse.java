package com.hhx.web_code.coreface;

import io.vavr.collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author hhx
 * @date 2022/8/8
 * @note
 */
public class MapTraverse {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, new Employee("Tom",20000.0,1));
        hashMap.put(2, new Employee("Jack",10000.0,2));
        hashMap.put(3, new Employee("Bob",30000.0,3));
        hashMap.put(4, new Employee("Mary",17000.0,4));

        Set keyset = hashMap.keySet();
        for(Object key :keyset){
            Employee employee = (Employee)hashMap.get(key);
            System.out.println(employee.getName()+"\t"+employee.getSalary());
            if(employee.getSalary()>18000){
                System.out.println("超过18000");
            }
        }

    }
}
