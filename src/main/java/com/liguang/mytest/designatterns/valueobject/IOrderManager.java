package com.liguang.mytest.designatterns.valueobject;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Desc: Value Object 模式
 * Auth: fairy
 * Date: 2023/4/24 11:18
 */
public interface IOrderManager extends Remote {
    public Order getOrder(int id) throws RemoteException; // Value Object 模式

    public String getClietName(int id) throws RemoteException;

    public String getProdName(int id) throws RemoteException;

    public int getNumber(int id) throws RemoteException;
}
