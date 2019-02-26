package com.liguang.mytest.template;

import com.liguang.mytest.template.exception.BizRuntimeException;
import com.liguang.mytest.template.mode.BaseBizResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description: //模块目的、功能描述
 * User: liguang
 * Date: 2018/7/28
 * History: //修改历史
 */
@Service
public class TemplateBizService {

    @Resource
    private CommonBizTemplate commonBizTemplate;

    public BaseBizResult<String> query(String bizId) {
        return commonBizTemplate.execute(new AbstractDefaultBizCallBack<String>() {
            @Override
            public void beforeCheck() {
                if (StringUtils.isBlank(bizId)) {
                    throw new BizRuntimeException("001", "入参id值不能为空");
                }
                if (StringUtils.equals("a", bizId)) {
                    throw new BizRuntimeException("002", "入参id值不能为a");
                }
            }

            @Override
            public String doAction() {
                return "业务数据";
            }

            @Override
            public void afterAction(String s) {
                System.out.println("afterAction.....");
            }

            @Override
            public void finallyAction(String s) {
                System.out.println("finallyAction.....");
            }
        });
    }
}
