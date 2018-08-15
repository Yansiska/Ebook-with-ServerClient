/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_server;

import config.Koneksi;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import model.AutoG;
import model.mAdmin;
import model.mBook;
import model.mEmployee;
import model.mReading_Book;
import object.iAdmin;
import object.iAutoG;
import object.iBook;
import object.iEmployee;
import object.iReading_Book;

/**
 *
 * @author user
 */
public class Yansis_Server {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Koneksi obj = new Koneksi();
        obj.openConnection();
             try {
            Registry registry = LocateRegistry.createRegistry(1597); 
            iEmployee obj1 = new mEmployee();
            iAdmin obj2 = new mAdmin();
            iAutoG obj3 = new AutoG();
            iBook obj4 = new mBook();
            iReading_Book obj5 = new mReading_Book();
            registry.rebind("log1", obj1);
            registry.rebind ("log2", obj2);
            registry.rebind("log3", obj3);
            registry.rebind("log4", obj4);
            registry.rebind("log5", obj5);
            System.out.println("Object is registered.");
            System.out.println("Now server is waiting for client request...");
        }
        catch(RemoteException e) {
            System.out.println("FileServer: " + e);
        }
    }
    
}
