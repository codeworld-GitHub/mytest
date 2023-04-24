package com.liguang.mytest.designatterns.flyweight;

/**
 * Desc: note something here
 * Auth: fairy
 * Date: 2023/4/24 09:54
 */
public class FinancialReportManager implements IReportManager {
    protected String tenantId = null;

    public FinancialReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String creaateReport() {
        return "This is a financial report";
    }
}
