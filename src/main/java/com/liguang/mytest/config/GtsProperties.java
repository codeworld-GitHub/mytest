package com.liguang.mytest.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "gts")
public class GtsProperties {
    private Integer pageSize;
    private String cookie;
    private String secToken;
    private String collina;
    private String umId;

    private List<String> kafkaTopics;
}
