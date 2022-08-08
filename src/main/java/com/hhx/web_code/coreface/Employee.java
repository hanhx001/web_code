package com.hhx.web_code.coreface;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hhx
 * @date 2022/8/8
 * @note
 */
@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private Double salary;
    private int id;

}
