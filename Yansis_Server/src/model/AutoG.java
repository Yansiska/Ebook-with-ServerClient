/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Koneksi;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.Statement;
import object.iAutoG;

/**
 *
 * @author user
 */
public class AutoG extends UnicastRemoteObject implements iAutoG {
    private Koneksi obj_koneksi = new Koneksi();
    public AutoG() throws Exception
    {
        super();
    }
    public String autoidEmployee()
    {
        try 
        {
            obj_koneksi.openConnection();
            
            String sql = "select top 1 ID_Employee from Employee order by ID_Employee desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String idemployee = null;
            String id = null;
               
            if(rs.next())
            {
                idemployee = rs.getString("ID_Employee");
                String potong = idemployee.substring(1); //untung memotong id
                int subidemployee = Integer.parseInt(potong) + 1;
                 if(subidemployee<10)
                {
                    id = "E000" + Integer.toString(subidemployee);
                }
                else if(subidemployee<100)
                {
                    id = "E00" + Integer.toString(subidemployee);
                }
                else if(subidemployee<1000)
                {
                    id = "E0" + Integer.toString(subidemployee);
                }
                else if(subidemployee<10000)
                {
                    id = "E" + Integer.toString(subidemployee);
                }
                
            }
            else
            {
                id = "E0001";
            }
            return id;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public String autoidAdmin()
    {
        try 
        {
            obj_koneksi.openConnection();
            
            String sql = "select top 1 ID_Admin from Admin order by ID_Admin desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String idamin = null;
            String id = null;
               
            if(rs.next())
            {
                idamin = rs.getString("ID_Admin");
                String potong = idamin.substring(1); //untung memotong id
                int subidadmin = Integer.parseInt(potong) + 1;
                 if(subidadmin<10)
                {
                    id = "A000" + Integer.toString(subidadmin);
                }
                else if(subidadmin<100)
                {
                    id = "A00" + Integer.toString(subidadmin);
                }
                else if(subidadmin<1000)
                {
                    id = "A0" + Integer.toString(subidadmin);
                }
                else if(subidadmin<10000)
                {
                    id = "A" + Integer.toString(subidadmin);
                }
                
            }
            else
            {
                id = "A0001";
            }
            return id;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public String autoidBook()
    {
        try 
        {
            obj_koneksi.openConnection();
            
            String sql = "select top 1 ID_Book from Book order by ID_Book desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String idemployee = null;
            String id = null;
               
            if(rs.next())
            {
                idemployee = rs.getString("ID_Book");
                String potong = idemployee.substring(1); //untung memotong id
                int subidemployee = Integer.parseInt(potong) + 1;
                 if(subidemployee<10)
                {
                    id = "B000" + Integer.toString(subidemployee);
                }
                else if(subidemployee<100)
                {
                    id = "B00" + Integer.toString(subidemployee);
                }
                else if(subidemployee<1000)
                {
                    id = "B0" + Integer.toString(subidemployee);
                }
                else if(subidemployee<10000)
                {
                    id = "B" + Integer.toString(subidemployee);
                }
                
            }
            else
            {
                id = "B0001";
            }
            return id;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public String autoidUser()
    {
        try 
        {
            obj_koneksi.openConnection();
            
            String sql = "select top 1 ID_User from User order by ID_User desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String idamin = null;
            String id = null;
               
            if(rs.next())
            {
                idamin = rs.getString("ID_User");
                String potong = idamin.substring(1); //untung memotong id
                int subidadmin = Integer.parseInt(potong) + 1;
                 if(subidadmin<10)
                {
                    id = "U000" + Integer.toString(subidadmin);
                }
                else if(subidadmin<100)
                {
                    id = "U00" + Integer.toString(subidadmin);
                }
                else if(subidadmin<1000)
                {
                    id = "U0" + Integer.toString(subidadmin);
                }
                else if(subidadmin<10000)
                {
                    id = "U" + Integer.toString(subidadmin);
                }
                
            }
            else
            {
                id = "U0001";
            }
            return id;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public String autoidBacaBuku()
    {
        try 
        {
            obj_koneksi.openConnection();
            
            String sql = "select top 1 ID_RBook from Reading_Book order by ID_RBook desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String idamin = null;
            String id = null;
               
            if(rs.next())
            {
                idamin = rs.getString("ID_RBook");
                String potong = idamin.substring(1); //untung memotong id
                int subidadmin = Integer.parseInt(potong) + 1;
                 if(subidadmin<10)
                {
                    id = "RB000" + Integer.toString(subidadmin);
                }
                else if(subidadmin<100)
                {
                    id = "RB00" + Integer.toString(subidadmin);
                }
                else if(subidadmin<1000)
                {
                    id = "RB0" + Integer.toString(subidadmin);
                }
                else if(subidadmin<10000)
                {
                    id = "RB" + Integer.toString(subidadmin);
                }
                
            }
            else
            {
                id = "RB0001";
            }
            return id;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
}
