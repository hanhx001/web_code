package com.hhx.web_code.gee100;

import com.hhx.web_code.lambada.Student;
import org.apache.tomcat.util.net.WriteBuffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author hhx
 * @date 2022/7/20
 * @note
 */
public class StreamTest {

    private static void getName(){

        List<Student> list = new ArrayList<>();
        list.stream().filter((Student s) -> s.getHeight()>160).
                collect(Collectors.groupingBy(Student::getHeight));

        list.parallelStream().filter((Student s) -> s.getHeight()>160).
                collect(Collectors.groupingBy(Student::getHeight));



    }
}
