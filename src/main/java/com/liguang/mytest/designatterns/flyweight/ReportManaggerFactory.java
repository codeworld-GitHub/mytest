package com.liguang.mytest.designatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc: 享元模式工厂
 * Auth: fairy
 * Date: 2023/4/24 09:57
 */
public class ReportManaggerFactory {
    Map<String, IReportManager> financialReportManager = new HashMap<>();
    Map<String, IReportManager> employeeReportManager = new HashMap<>();

    IReportManager getFinancialReportManager(String tenantId) {
        IReportManager r = financialReportManager.get(tenantId); // 通过租户ID 获取享元
        if (r == null) {
            r = new FinancialReportManager(tenantId);
            financialReportManager.put(tenantId, r); // 维护已创建的享元对象
        }
        return r;
    }

    IReportManager getEmployeeReportManager(String tenantId) {
        IReportManager r = employeeReportManager.get(tenantId);
        if (r == null) {
            r = new EmployeeReportManager(tenantId);
            employeeReportManager.put(tenantId, r);
        }
        return r;
    }

    public static void main(String[] args) {
        ReportManaggerFactory rmf = new ReportManaggerFactory();
        IReportManager rm = rmf.getFinancialReportManager("A");
        System.out.println(rm.creaateReport());
    }
}
