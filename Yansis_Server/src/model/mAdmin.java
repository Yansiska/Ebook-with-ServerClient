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
import object.iAdmin;

/**
 *
 * @author user
 */
public class mAdmin extends UnicastRemoteObject implements iAdmin {
    private String idadmin, username, password;
    private Koneksi obj_koneksi = new Koneksi();

     public mAdmin()throws Exception
    {
        super();
    }

    public String getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(String idadmin) {
        this.idadmin = idadmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
            String str = "insert into Admin (ID_Admin,Username,Password) values(?,?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idadmin);
            pr.setString(2, username);
            pr.setString(3, password);
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
        int i = 0;
        try
        {
            obj_koneksi.openConnection();
            String str = "UPDATE Admin SET Username =  ?," +
                    "Password = ? "+
                    "where ID_Admin = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, username);
            pr.setString(2, password);
            pr.setString(3, idadmin);
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
         String str = "delete Admin where ID_Admin= ?";
         PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
         pr.setString(1, idadmin);
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
             String str = "select ID_Admin, Username,Password from Admin";
             ResultSet rs = stmt.executeQuery(str);
             while(rs.next())
             {
                 this.setIdadmin(rs.getString(1));
                 this.setUsername(rs.getString(2));
                 this.setPassword(rs.getString(3));
                 data.add(this.getIdadmin());
                 data.add(this.getUsername());
                 data.add(this.getPassword());
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
            String str = "select * from Admin where ID_Admin = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idadmin);
            ResultSet rs = pr.executeQuery();
            while(rs.next())
            {
                 this.setIdadmin(rs.getString(1));
                 this.setUsername(rs.getString(2));
                 this.setPassword(rs.getString(3));
                 data.add(this.getIdadmin());
                 data.add(this.getUsername());
                 data.add(this.getPassword());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
    }
 public int doLogin()
    {
        try 
        {
            obj_koneksi.openConnection();
            String sq = "select count(*) as jumlah from Admin where Username=? and Password=?";
            //pake prepare statment karena ada parameter
            PreparedStatement ps = obj_koneksi.con.prepareStatement(sq);
            ps.setString(1, getUsername());
            ps.setString(2, getPassword());
            
            ResultSet r = ps.executeQuery();
            int jumlah = 0;
            if(r.next())
            {
                jumlah = r.getInt("jumlah");
            }
            return jumlah;          
        } 
        catch (Exception e) 
        {
        }
        return 0;
    }
 public String[] caridataAdmin()
    {
        try 
        {
            obj_koneksi.openConnection();
            String sq = "select ID_Admin from Admin where Username=? AND Password=?";
            PreparedStatement ps = obj_koneksi.con.prepareStatement(sq);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet r = ps.executeQuery();
            String[] data = new String[1];
            if(r.next())
            {
                data[0]= r.getString("ID_Admin");
            }
            else
            {
               data[0]= "kosong";
            }
            return data;          
        } 
        catch (Exception e) 
        {
        }
        return null;
    }
}
