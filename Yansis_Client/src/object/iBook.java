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
public interface iBook extends Remote {
    public String getIdBuku() throws RemoteException;;
    public void setIdBuku(String idbuku) throws RemoteException;;
    public String getNameBuku() throws RemoteException;;
    public void setNameBuku(String namebuku) throws RemoteException;;
    public String getPublisher() throws RemoteException;;
    public void setPublisher(String publisher) throws RemoteException;;
    public int getStock() throws RemoteException;;
    public void setStock(int stock) throws RemoteException;;
    public int doInsert() throws RemoteException;;
    public int doUpdate() throws RemoteException;;
    public int doDelete() throws RemoteException;;  
    public ArrayList display() throws RemoteException;;
    public ArrayList getRecord() throws RemoteException;;
    public  ArrayList searchEmployee() throws RemoteException;;
    
}
