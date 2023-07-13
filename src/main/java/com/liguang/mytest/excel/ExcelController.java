package com.liguang.mytest.excel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author fairy
 * @date 2023/6/30 17:33
 */
@RestController
public class ExcelController {
    /**
     * excel 模板
     */
    @Value("classpath:baojiadan.xlsx")
    private Resource baojiadanFile;

}
