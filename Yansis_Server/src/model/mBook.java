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
import object.iBook;

/**
 *
 * @author user
 */
public class mBook extends UnicastRemoteObject implements iBook {
    private String idbuku,namebuku,publisher; 
   private int stock;
    
    private Koneksi obj_koneksi = new Koneksi();
    
    public mBook()throws Exception
    {
        super();
    }
    
    public String getIdBuku() {
        return idbuku;
    }

    public void setIdBuku(String idbuku) {
        this.idbuku = idbuku;
    }

    public String getNameBuku() {
        return namebuku;
    }

    public void setNameBuku(String namebuku) {
        this.namebuku = namebuku;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
            String str = "insert into Book (ID_Book,Book_Name,Publisher,Stock) values(?,?,?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idbuku);
            pr.setString(2, namebuku);
            pr.setString(3, publisher);
            pr.setInt (4, stock);
            
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    public int doUpdate() {
        int i = 0;
        try
        {
            obj_koneksi.openConnection();
            String str = "UPDATE Book SET Book_Name =  ?," +
                    "Publisher = ? "+ "Stock = ? "+
                    "WHERE ID_Book = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1,namebuku);
            pr.setString(2,publisher);
            pr.setInt(3, stock);
            pr.setString(4,idbuku);
            i = pr.executeUpdate();
        }
        catch(SQLException ex){
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
         String str = "delete Book where ID_Book= ?";
         PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
         pr.setString(1, idbuku);
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
             String str = "select ID_Book,Book_Name,Publisher,Stock from Book";
             ResultSet rs = stmt.executeQuery(str);
             while(rs.next())
             {
                 this.setIdBuku(rs.getString(1));
                 this.setNameBuku(rs.getString(2));
                 this.setPublisher(rs.getString(3));
                 this.setStock(rs.getInt(4));
                 data.add(this.getIdBuku());
                 data.add(this.getNameBuku());
                 data.add(this.getPublisher());
                 data.add(this.getStock());
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
            String str = "select * from Book where ID_Book = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idbuku);
            ResultSet rs = pr.executeQuery();
            while(rs.next())
            {
                this.setIdBuku(rs.getString(1));
                 this.setNameBuku(rs.getString(2));
                 this.setPublisher(rs.getString(3));
                 this.setStock(rs.getInt(4));
                 data.add(this.getIdBuku());
                 data.add(this.getNameBuku());
                 data.add(this.getPublisher());
                 data.add(this.getStock());
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
            String sql = "select Book_Name from Book where ID_Book = ? ";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(sql);
            pr.setString(1, idbuku);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
            {
                this.setNameBuku(rs.getString(1));
                data.add(this.getNameBuku());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
        
    }
    
}
