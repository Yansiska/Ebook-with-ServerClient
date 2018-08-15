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
public interface iReading_Book extends Remote {
    public String getIdBacaBuku() throws RemoteException;;
    public void setIdBacaBuku(String idbacabuku) throws RemoteException;;
    public String getNama() throws RemoteException;;
    public void setNama(String nama) throws RemoteException;;
    public String getNameBuku() throws RemoteException;;
    public void setNameBuku(String namebuku) throws RemoteException;;
    public int getQty() throws RemoteException;;
    public void setQty(int qty) throws RemoteException;;
    public String getDate() throws RemoteException;;
    public void setDate(String date) throws RemoteException;;
    public int doInsert() throws RemoteException;;
    public int doUpdate() throws RemoteException;;
    public int doDelete() throws RemoteException;;  
    public ArrayList display() throws RemoteException;;
    public ArrayList getRecord() throws RemoteException;;
    public  ArrayList searchEmployee() throws RemoteException;;
    
}
