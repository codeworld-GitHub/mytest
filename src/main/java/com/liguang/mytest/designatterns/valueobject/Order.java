package com.liguang.mytest.designatterns.valueobject;

import lombok.Data;

import java.io.Serializable;

/**
 * Desc: note something here
 * Auth: fairy
 * Date: 2023/4/24 11:19
 */
@Data
public class Order implements Serializable {
    private int orderId;
    private String clientName;
    private int number;
    private String projectName;
}
