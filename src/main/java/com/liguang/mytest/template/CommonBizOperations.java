package com.liguang.mytest.template;

import com.liguang.mytest.template.mode.BaseBizResult;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/7/28
 * History: //修改历史
 */

public interface CommonBizOperations {
    <T> BaseBizResult<T> execute(CommonBizCallBack<T> callBack);
}
