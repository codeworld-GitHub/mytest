package com.liguang.mytest.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author liguang
 * @description do something here
 * @date 2018年11月14日 18:08
 */
public enum TestOrdinal {
    GREEN(1, "绿色"), BLUE(2, "蓝色"), RED(3, "红色");

    private int type;
    private String desc;
    private static Map<Integer, TestOrdinal> mapType = Maps.newHashMap();
    private static Map<String, TestOrdinal> mapDesc = Maps.newHashMap();

    static {
        for (TestOrdinal legEnum : TestOrdinal.values()) {
            mapType.put(legEnum.getNum(), legEnum);
            mapDesc.put(legEnum.getDesc(), legEnum);
        }
    }

    TestOrdinal(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    @JsonCreator
    public static TestOrdinal getItem(int num) {
        return mapType.get(num);
    }

    @JsonCreator
    public static TestOrdinal getItem(String desc) {
        return mapDesc.get(desc);
    }

    @JsonValue
    public int getNum() {
        return this.type;
    }

    public String getDesc() {
        return this.desc;
    }

    public static Map<Integer, TestOrdinal> getMapType() {
        return mapType;
    }

    public static Map<String, TestOrdinal> getMapDesc() {
        return mapDesc;
    }
}
