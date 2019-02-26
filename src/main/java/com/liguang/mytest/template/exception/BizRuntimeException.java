package com.liguang.mytest.template.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/7/28
 * History: //修改历史
 */
@Data
@AllArgsConstructor
public class BizRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1865289288556610375L;
    private String errCode;
    private String errMsg;
}
