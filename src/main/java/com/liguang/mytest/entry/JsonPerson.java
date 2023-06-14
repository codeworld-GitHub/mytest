package com.liguang.mytest.entry;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author fairy
 * @date 2023/5/31 10:30
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonPerson {
    @JSONField(alternateNames = "Amd.id")
    private String id;

    @JSONField(alternateNames = "Amd.name")
    private String name;

    private Integer age;

    private String address;
}
