/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface iEmployee extends Remote {
    public String getIdemployee() throws RemoteException;;
    public void setIdemployee(String idemployee) throws RemoteException;;
    public String getName() throws RemoteException;;
    public void setName(String name) throws RemoteException;;
    public String getPosition() throws RemoteException;;
    public void setPosition(String position) throws RemoteException;;  
    public int doInsert() throws RemoteException;;
    public int doUpdate() throws RemoteException;;
    public int doDelete() throws RemoteException;;  
    public ArrayList display() throws RemoteException;;
    public ArrayList getRecord() throws RemoteException;;
    public  ArrayList searchEmployee() throws RemoteException;;
  
    
}
