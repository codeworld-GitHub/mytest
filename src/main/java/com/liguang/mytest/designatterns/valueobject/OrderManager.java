package com.liguang.mytest.designatterns.valueobject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Desc: note something here
 * Auth: fairy
 * Date: 2023/4/24 11:22
 */
public class OrderManager extends UnicastRemoteObject implements IOrderManager {
    protected OrderManager() throws RemoteException {
        super();
    }

    @Override
    public Order getOrder(int id) throws RemoteException {
        Order order = new Order();
        order.setClientName("billy");
        order.setNumber(20);
        order.setProjectName("desk");
        return order;
    }

    @Override
    public String getClietName(int id) throws RemoteException {
        return "billy";
    }

    @Override
    public String getProdName(int id) throws RemoteException {
        return "desk";
    }

    @Override
    public int getNumber(int id) throws RemoteException {
        return 20;
    }
}
