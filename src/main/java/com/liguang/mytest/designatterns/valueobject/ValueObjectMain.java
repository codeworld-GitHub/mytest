package com.liguang.mytest.designatterns.valueobject;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Desc: note something here
 * Auth: fairy
 * Date: 2023/4/24 11:28
 */
public class ValueObjectMain {
    public static void main(String[] args) {
        try {
            IOrderManager usermanager = (IOrderManager) Naming.lookup("OrderManager");
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                usermanager.getOrder(i);
            }
            System.out.println("getOrder sped:" + (System.currentTimeMillis() - begin));

            begin = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                usermanager.getClietName(i);
                usermanager.getNumber(i);
                usermanager.getProdName(i);
            }
            System.out.println("3 Method call sped:" + (System.currentTimeMillis() - begin));
            System.out.println(usermanager.getOrder(0).getClientName());

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            System.out.println("OrderManager exception:" + e);
        }
    }
}
