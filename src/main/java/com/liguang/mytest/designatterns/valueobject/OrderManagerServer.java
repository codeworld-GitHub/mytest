package com.liguang.mytest.designatterns.valueobject;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.StringTokenizer;

/**
 * Desc: note something here
 * Auth: fairy
 * Date: 2023/4/24 11:25
 */
public class OrderManagerServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // 注册RMI端口
            IOrderManager usermanagger = new OrderManager(); // RMI远程对象
            Naming.rebind("OrderManager", usermanagger); // 绑定RMI对象
            System.out.println("OrderManager is ready.");
            StringTokenizer ss = new StringTokenizer("", "s");
        } catch (RemoteException | MalformedURLException e) {
            System.out.println("OrderManager Server failed:" + e);
        }
    }
}
