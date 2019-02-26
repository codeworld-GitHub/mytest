package com.liguang.mytest.enums;

/**
 * @author liguang3096
 * @Description do something here
 * @date 2019-02-22 15:09
 */
public enum KafkaEnums {
    AAA("aaa") {
        @Override
        public void doSome() {
            System.out.println("我是AAA");
        }
    },

    BBB("bbb") {
        @Override
        public void doSome() {
            System.out.println("BBB");
        }
    };

    private String key;

    KafkaEnums(String key) {
        this.key = key;
    }

    public void doSome() {

    }
}
