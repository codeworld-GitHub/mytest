package com.liguang.mytest;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.liguang.mytest.entry.JsonPerson;
import com.liguang.mytest.entry.Person;
import com.liguang.mytest.entry.PersonModel;
import com.liguang.mytest.enums.TestOrdinal;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.stream.*;

/**
 * Description: to do something
 * User: lg
 * Date: 2018/08/29
 */
public class JustTest {
    @BeforeEach
    public void setUp() {
        System.out.println("steUp");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown");
    }

    @BeforeAll
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterAll
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
        if(Boolean.TRUE.equals(null)){

        }
    }
    @Test
    public void testJson(){
        String str = "{\"goods_info_marketing:2c95e2ae874b3a6101874b3b658b0c44\":{\"FLASH_PROMOTION:84\":\"{\\\"beginTime\\\":\\\"2023-05-04T09:15:00\\\",\\\"endTime\\\":\\\"2023-05-20T23:59:00\\\",\\\"id\\\":84,\\\"marketingPluginType\\\":\\\"FLASH_PROMOTION\\\",\\\"price\\\":330,\\\"skuId\\\":\\\"2c95e2ae874b3a6101874b3b658b0c44\\\"}\"}}";
        Map<String, Map<String, String>> stringMapMap = JSONObject.parseObject(str, new TypeReference<Map<String, Map<String, String>>>() {});
        System.out.println(JSONObject.toJSONString(stringMapMap));
        System.out.println(JSONObject.toJSONString(LocalDateTime.now()));

        Person person = Person.builder().totalPrice(new BigDecimal("10000.69")).build();
        String jsonObject = JSONObject.toJSONString(person);
        PersonModel person2 = JSONObject.parseObject(jsonObject, PersonModel.class);
        person2.setTotalPrice(person.getTotalPrice().toPlainString());
        System.out.println(JSONObject.toJSONString(person2));

        str="{\"Amd.id\":\"123\",\"Amd.name\":\"张三\",\"age\":1,\"address\":\"南京路\"}";
        JsonPerson jsonPerson = JSONObject.parseObject(str, JsonPerson.class);

        String newStr = JSONObject.toJSONString(jsonPerson);
        jsonPerson = JSONObject.parseObject(newStr, JsonPerson.class);
        System.out.println(JSONObject.toJSONString(jsonPerson));
    }
}
