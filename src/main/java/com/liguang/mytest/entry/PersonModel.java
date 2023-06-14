package com.liguang.mytest.entry;

import com.liguang.mytest.enums.TestOrdinal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Description: to do something
 * User: lg
 * Date: 2018/09/17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel implements Serializable {
    private static final long serialVersionUID = -6336461603721866625L;

    private String id;
    private String name;
    private Integer age;
    private Integer sex;
    private TestOrdinal testOrdinal;
    private String github;
    private Double salary;

    private String count;
    private String total;

    private String totalPrice;
}
