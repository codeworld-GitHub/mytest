package com.liguang.mytest.word;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 描述:
 *
 * @author fairy
 * @date 2023/6/26 17:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goods {
    /**
     * 序号
     */
    private Integer no;
    /**
     * 型号
     */
    private String modelNo;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 合计
     */
    private BigDecimal totalPrice;
    /**
     * 备注
     */
    private String remark;
}
