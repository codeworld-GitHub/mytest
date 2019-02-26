package com.liguang.mytest.template;

import com.liguang.mytest.template.exception.BizRuntimeException;
import com.liguang.mytest.template.mode.BaseBizResult;
import org.springframework.stereotype.Component;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/7/28
 * History: //修改历史
 */
@Component
public class CommonBizTemplate implements CommonBizOperations {
    @Override
    public <T> BaseBizResult<T> execute(CommonBizCallBack<T> callBack) {
        T t = null;
        try {
            callBack.beforeCheck();
            t = callBack.doAction();
            callBack.afterAction(t);
            return buildSuccessResult(t);
        } catch (BizRuntimeException e) {
            return buildErrorResult(e.getErrCode(), e.getErrMsg());
        } catch (Exception e) {
            return buildErrorResult("911", "未知异常");
        } finally {
            callBack.finallyAction(t);
        }
    }

    private static <T> BaseBizResult<T> buildErrorResult(String errCode, String errMsg) {
        return new BaseBizResult<T>().success(1).errCode(errCode).errMsg(errMsg);
    }

    private static <T> BaseBizResult<T> buildSuccessResult(T t) {
        return new BaseBizResult<T>().success(0).data(t);
    }

}
