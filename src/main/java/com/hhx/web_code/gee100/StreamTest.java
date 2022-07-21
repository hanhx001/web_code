package com.hhx.web_code.gee100;

import com.hhx.web_code.lambada.Student;
import org.apache.tomcat.util.net.WriteBuffer;

import java.util.*;
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

    private void getConsumableMediaTypes(){
        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);

        List<String> flatMapList = playersInWorldCup2016.stream()
                .flatMap(pList -> pList.stream())
                .collect(Collectors.toList());

    }
}
