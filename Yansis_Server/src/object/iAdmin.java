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
public interface iAdmin extends Remote {
    public String getIdadmin() throws RemoteException;;
    public void setIdadmin(String idadmin) throws RemoteException;;
    public String getUsername() throws RemoteException;;
    public void setUsername(String username) throws RemoteException;;
    public String getPassword() throws RemoteException;;
    public void setPassword(String password) throws RemoteException;; 
    public int doInsert() throws RemoteException;;
    public int doUpdate() throws RemoteException;;
    public int doDelete() throws RemoteException;;  
    public ArrayList display() throws RemoteException;;
    public ArrayList getRecord() throws RemoteException;;
    public int doLogin() throws RemoteException;;  
    public String[] caridataAdmin() throws RemoteException;;
}
