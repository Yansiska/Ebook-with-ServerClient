/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class Koneksi {
    public Connection con;

    //method
    public void openConnection() {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Latihan;IntegratedSecurity=true";
            con = DriverManager.getConnection(url);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
