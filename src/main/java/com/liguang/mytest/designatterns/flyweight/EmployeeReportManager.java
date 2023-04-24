package com.liguang.mytest.designatterns.flyweight;

/**
 * Desc: note something here
 * Auth: fairy
 * Date: 2023/4/24 09:56
 */
public class EmployeeReportManager implements IReportManager {
    protected String tenantId = null;

    public EmployeeReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String creaateReport() {
        return "This is aa employee report";
    }
}
