package com.liguang.mytest.template.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.liguang.mytest.properties.GtsProperties;
import com.liguang.mytest.template.TemplateBizService;
import com.liguang.mytest.template.mode.BaseBizResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/7/28
 * History: //修改历史
 */
@Slf4j
@RestController
public class SampleController {

    @Autowired
    private TemplateBizService templateBizService;

    @Resource
    private GtsProperties gtsProperties;

    @GetMapping
    public Map<String, String> query(String id) {
        HashMap<String, String> map = Maps.newHashMap();
        BaseBizResult<String> result = templateBizService.query(id);
        if (result.isSuccess()) {
            map.put("success", result.getData());
        } else {
            map.put(result.getErrCode(), result.getErrMsg());
        }
        return map;
    }

    @GetMapping("/getProperties")
    public void getGtsProperteis() {
        log.info("gts:{}", gtsProperties.getCollina());
        log.info("gtsProperties:{}", JSON.toJSONString(gtsProperties));
    }

}
