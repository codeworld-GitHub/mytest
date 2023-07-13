package com.liguang.mytest.word;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 描述:
 *
 * @author fairy
 * @date 2023/6/26 17:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TradeContract {

    /**
     * 合同编号
     */
    private String contractNo;
    /**
     * 甲方(采购方)
     */
    private String buyerName;
    /**
     * 联系地址
     */
    private String concatAddress;
    /**
     * 联系人
     */
    private String concatPeople;
    /**
     * 联系电话
     */
    private String concatPhone;
    /**
     * 合计金额大写
     */
    private String bigTotalPrice;
    /**
     * 合计金额小写
     */
    private BigDecimal smallTotalPrice;
    /**
     * 运输方式
     */
    private String deliveryWay;
    /**
     * 运费
     */
    private BigDecimal deliveryFreight;
    /**
     * 经办人
     */
    private String chargePeople;
    /**
     * 收货地址
     */
    private String tradeAddress;
    /**
     * 收件人
     */
    private String tradePeople;
    /**
     * 收件人手机号
     */
    private String tradePhone;
    /**
     * 发票抬头
     */
    private String billTitle;
    /**
     * 纳税人识别号
     */
    private String billNo;
    /**
     * 纳税人地址
     */
    private String billAddress;
    /**
     * 电话
     */
    private String billPhone;
    /**
     * 开户行
     */
    private String billBank;
    /**
     * 银行账号
     */
    private String billBankNo;
    /**
     * 甲方经办人签字盖章
     */
    private String aSign;
    /**
     * 乙方经办人签字盖章
     */
    private String bSign;
    /**
     * 签订日期
     */
    private String signDate;
    /**
     * 货物信息
     */
    private List<Goods> goods;
}
