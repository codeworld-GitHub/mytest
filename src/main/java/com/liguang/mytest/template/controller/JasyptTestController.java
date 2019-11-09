package com.liguang.mytest.template.controller;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JasyptTestController {
    @Autowired
    private StringEncryptor stringEncryptor;

    @RequestMapping("jasptTest")
    public void jasyptTest(){
        System.out.println(stringEncryptor.encrypt("123456"));
    }
}
