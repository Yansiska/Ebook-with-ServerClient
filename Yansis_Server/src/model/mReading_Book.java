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
import object.iReading_Book;

/**
 *
 * @author user
 */
public class mReading_Book extends UnicastRemoteObject implements iReading_Book {
    private String idbacabuku,nama,namebuku,date; 
   private int qty;
   
   private Koneksi obj_koneksi = new Koneksi();
    
    public mReading_Book()throws Exception
    {
        super();
    }
    
    public String getIdBacaBuku() {
        return idbacabuku;
    }

    public void setIdBacaBuku(String idbacabuku) {
        this.idbacabuku = idbacabuku;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNameBuku() {
        return namebuku;
    }

    public void setNameBuku(String namebuku) {
        this.namebuku = namebuku;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
            String str = "insert into Reading_Book (ID_RBook,Name,Book_Name,Qty,Date) values(?,?,?,?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idbacabuku);
            pr.setString(2, nama);
            pr.setString(3, namebuku);
            pr.setInt (4, qty);
            pr.setString(5, date);
            
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
            String str = "UPDATE Reading_Book SET Name =  ?," +
                    "Book_Name =  ? "+
                    "Qty = ? "+
                    "Date = ? "+
                    "WHERE ID_RBook = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idbacabuku);
            pr.setString(2, nama);
            pr.setString(3, namebuku);
            //pr.setInt (4, stock);
            pr.setInt (4, qty);
            pr.setString(5, date);
            
            
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
         String str = "delete Reading_Book where ID_RBook= ?";
         PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
         pr.setString(1, idbacabuku);
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
             String str = "select ID_RBook,Name,Book_Name,Qty,Date from Reading_Book";
             ResultSet rs = stmt.executeQuery(str);
             while(rs.next())
             {
                 this.setIdBacaBuku(rs.getString(1));
                 this.setNama(rs.getString(2));
                 this.setNameBuku(rs.getString(3));
                 //this.setStock(rs.getInt(4));
                 this.setQty(rs.getInt(4));
                 this.setDate(rs.getString(5));
                 data.add(this.getIdBacaBuku());
                 data.add(this.getNama());
                 data.add(this.getNameBuku());
                 //data.add(this.getStock());
                 data.add(this.getQty());
                 data.add(this.getDate());
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
            String str = "select * from Reading_Book where ID_RBook = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, idbacabuku);
            ResultSet rs = pr.executeQuery();
            while(rs.next())
            {
                this.setIdBacaBuku(rs.getString(1));
                 this.setNama(rs.getString(2));
                 this.setNameBuku(rs.getString(3));
                 //this.setStock(rs.getInt(4));
                 this.setQty(rs.getInt(4));
                 this.setDate(rs.getString(5));
                 data.add(this.getIdBacaBuku());
                 data.add(this.getNama());
                 data.add(this.getNameBuku());
                 //data.add(this.getStock());
                 data.add(this.getQty());
                 data.add(this.getDate());
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
            String sql = "select Name from Reading_Book where ID_RBook = ? ";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(sql);
            pr.setString(1, idbacabuku);
            ResultSet rs = pr.executeQuery();
            if (rs.next())
            {
                this.setNama(rs.getString(1));
                data.add(this.getNama());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
        
    }
}
