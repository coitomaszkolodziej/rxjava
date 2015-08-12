/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.queries;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import pakiet.DBConnection;

/**
 *
 * @author Praktyki
 */
public class InsertArtistsQuery implements Executable{
    public void execute(Query query, List<Object> parameters) 
    {
        int id=(Integer) parameters.get(0);
        String name=(String) parameters.get(1);
        String surname=(String) parameters.get(2);
        int age=(Integer) parameters.get(3);
        
        try
        {
            PreparedStatement q;
                q = QueryHelper.getPreparedStatement(query, parameters);
                
                q.setInt(1,id);
                q.setString(2,name);
                q.setString(3,surname);
                q.setInt(4, age);
                
                q.executeQuery();
                q.close();
        }
        catch(SQLException e){}
    }
    
    
    public List<Object> insertIntoList()
    {   
        int age=0;
        String name="",surname=""; //wartosci wstawiane do listy
        
        int i=1;//licznik wierszy w tabeli
        
        Random randomAge; // wylosowane wartosci wstawiane do tabeli
        RandomValue random = new RandomValue();
        
        List<String> nazwiska = new ArrayList<String>(); //lista z nazwiskami wczytanymi z pliku
        List<String> imiona = new ArrayList<String>(); //lista z imionami wczytanymi z pliku
        
        DataLoader dataLoader = new DataLoader();
        
        PreparedStatement ps;
        List<Object> list=new ArrayList<Object>();
        
        String st = new String("SELECT artist_id FROM artists ORDER BY artist_id DESC LIMIT 1");
                        try
                        {   
                            Connection conn = DBConnection.getConnection();
                            ps=conn.prepareStatement(st);
                            ResultSet rs;
                            rs = ps.executeQuery();
                            while (rs.next())
                            {
                                    i = (Integer) rs.getObject(1);      
                            }
                            
                            imiona=dataLoader.getNames();
                            name=random.randomValue(imiona);
                            
                            nazwiska=dataLoader.getSurnames();
                            surname = random.randomValue(nazwiska);
                            
                            randomAge = new Random();
                            age = randomAge.nextInt((80-20) + 1) + 20;
                  
                            conn.close();
                            rs.close();
                            System.out.println(i);
                        }
                        catch(SQLException e){System.out.println(e);}
                        catch(ClassNotFoundException e){System.out.println(e);}
                        
                list.add(i+1);
                list.add(name);
                list.add(surname);
                list.add(age);
        return list;
    }
   
}
