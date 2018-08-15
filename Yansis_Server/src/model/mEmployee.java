/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Koneksi;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import object.iEmployee;

/**
 *
 * @author user
 */
public class mEmployee extends UnicastRemoteObject implements iEmployee {
   private String idemployee,name,position;
    private Koneksi obj_koneksi = new Koneksi();
    
    public mEmployee()throws Exception
    {
        super();
    }

    public String getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(String idemployee) {
        this.idemployee = idemployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Koneksi getObj_koneksi() {
        return obj_koneksi;
    }

    public void setObj_koneksi(Koneksi obj_koneksi) {
        this.obj_koneksi = obj_koneksi;
    }
    public int doInsert()
    {
        int i = 0 ;
        try
        {
            obj_koneksi.openConnection();
            String str = "insert into Employee (ID_Employee,Name,Position) values(?,?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idemployee);
            pr.setString(2, name);
            pr.setString(3, position);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    
    public int doUpdate()
    {
        int i = 0 ;
        try
        {
            obj_koneksi.openConnection();
            String str = "update Employee set Name= ?,"+
                        "Position= ? "+
                         "where ID_Employee = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, name);
            pr.setString(2, position);
            pr.setString(3, idemployee);
            i = pr.executeUpdate();
                  
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    public int doDelete()
    {
        int i = 0 ;
        try
        {
         obj_koneksi.openConnection();
         String str = "delete Employee where ID_Employee= ?";
         PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
         pr.setString(1, idemployee);
         i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    
    public ArrayList display()
    {
         ArrayList data = new ArrayList();
         try
         {
             obj_koneksi.openConnection();
             Statement stmt = obj_koneksi.con.createStatement();
             String str = "select ID_Employee,Name,Position from Employee";
             ResultSet rs = stmt.executeQuery(str);
             while(rs.next())
             {
                 this.setIdemployee(rs.getString(1));
                 this.setName(rs.getString(2));
                 this.setPosition(rs.getString(3));
                 data.add(this.getIdemployee());
                 data.add(this.getName());
                 data.add(this.getPosition());
             }
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
         return data;
    }
    public ArrayList getRecord()
    {
        ArrayList data = new ArrayList();
        try
        {
            obj_koneksi.openConnection();
            String str = "select * from Employee where ID_Employee = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idemployee);
            ResultSet rs = pr.executeQuery();
            while(rs.next())
            {
                this.setIdemployee(rs.getString(1));
                this.setName(rs.getString(2));
                this.setPosition(rs.getString(3));
                data.add(this.getIdemployee());
                data.add(this.getName());
                data.add(this.getPosition());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
    }
     public ArrayList searchEmployee()
    {
        ArrayList data = new ArrayList();
        try
        {
            obj_koneksi.openConnection();
            String sql = "select Name from Employee where ID_Employee = ? ";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(sql);
            pr.setString(1, idemployee);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
            {
                this.setName(rs.getString(1));
                data.add(this.getName());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
        
    }
} 
