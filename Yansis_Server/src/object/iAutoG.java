/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author user
 */
public interface iAutoG extends Remote{
    public String autoidAdmin() throws RemoteException;;
    public String autoidEmployee() throws RemoteException;;
    public String autoidBook() throws RemoteException;;
    public String autoidBacaBuku() throws RemoteException;;
    
}
