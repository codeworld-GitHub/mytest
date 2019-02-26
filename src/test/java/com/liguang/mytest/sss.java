package com.liguang.mytest;

import com.google.common.collect.Lists;
import com.liguang.mytest.entry.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liguang3096
 * @Description do something here
 * @date 2019-01-29 20:13
 */
public class sss {
    public static void main(String[] args) {
        Person build = Person.builder().age(1).salary(100d).build();
        Person build2 = Person.builder().age(2).salary(100d).build();
        Person build3 = Person.builder().age(2).salary(100d).build();
        Person build4 = Person.builder().age(4).salary(100d).build();
        Person build5 = Person.builder().age(3).salary(100d).build();
        List<Person> arrayList = Lists.newArrayList(build, build2, build3, build4, build5);
        List<Person> unique = arrayList.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(Person::getAge))), ArrayList::new)
        );
        System.out.println(unique);

        List<Person> people = new ArrayList<>(arrayList.stream().collect(Collectors.toMap(Person::getAge, person -> person, (age1, age2) -> age1)).values());
        System.out.println(people);

        Map<Integer, DoubleSummaryStatistics> group = arrayList.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.summarizingDouble(Person::getSalary)));
        System.out.println(group);
    }
}
