package com.liguang.mytest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.liguang.mytest.entry.Person;
import com.liguang.mytest.enums.TestOrdinal;
import org.apache.commons.codec.binary.Base64;
import org.junit.*;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToLongFunction;
import java.util.stream.*;

/**
 * Description: to do something
 * User: lg
 * Date: 2018/08/29
 */
public class JustTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("steUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Test
    public void streamTest() {
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
        System.out.println(streamGenerated.collect(Collectors.toList()));

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        System.out.println(streamIterated.collect(Collectors.toList()));

        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);
        IntStream streamOfChars = "abc".chars();
    }

    @Test
    public void testBeforeAfter() {
        System.out.println("testBeforeAfter");
    }

    @Test
    public void testTryFinally() {
        Person person = this.getPerson();
        System.out.println(person);
    }

    private Person getPerson() {
        Person person = Person.builder().build();
        try {
            person.setName("李广");
            System.out.println("try");
            return person;
        } finally {
            person.setAge(12);
            System.out.println("finally");
        }
    }

    @Test
    public void testBase64() {
        String s = new String(Base64.encodeBase64("qmtest1".getBytes()));
        System.out.println(s);

        String s1 = new String(Base64.decodeBase64("0568e5c8caa09645a9e25bcec301a9f1"));
        System.out.println(s1);

    }

    @Test
    public void testEnum() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = Person.builder().age(10).name("张三").sex(1).testOrdinal(TestOrdinal.GREEN).build();
        String s = mapper.writeValueAsString(person);
        System.out.println(s);


        TestOrdinal item = TestOrdinal.getItem(1);
        TestOrdinal item1 = TestOrdinal.getItem("红色");
        System.out.println(item.getDesc());
        System.out.println(item1.getNum());

        Person person1 = mapper.readValue(s, Person.class);
        System.out.println(person1);
    }

    @Test
    public void testSppliter() {
        Map<Long, String> idAndNameMap = Maps.newHashMap();
        idAndNameMap.put(123L, "张三");
        idAndNameMap.put(223L, "李四");
        String collect = Arrays.stream("0|123|223|".split("\\|"))
                .mapToLong(Long::valueOf)
                .filter(value -> value != 0)
                .mapToObj(idAndNameMap::get)
                .collect(Collectors.joining("/"));
        System.out.println(collect);
    }
}
