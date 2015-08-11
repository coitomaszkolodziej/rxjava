/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.postgresql.util.PSQLException;
import pakiet.DBConnection;

/**
 *
 * @author Praktyki
 */
public class UpdateArtistsQuery implements Executable{
    
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
                
                q.setInt(4,id);
                q.setString(1,name);
                q.setString(2,surname);
                q.setInt(3,age);
                
                q.executeQuery();
                q.close();
        }
        catch(SQLException e){}
    }
    
    public List<Object> insertIntoList()
    {
        
        int id=0,age=0;
        String name="",surname=""; //wartosci wstawiane do listy
        
        int i=1;//licznik wierszy w tabeli
        
        Random randomID,randomAge,randomSurname,randomName; // wylosowane wartosci wstawiane do tabeli
        
        List<String> nazwiska = new ArrayList<String>(); //lista z nazwiskami wczytanymi z pliku
        List<String> imiona = new ArrayList<String>(); //lista z imionami wczytanymi z pliku

        PreparedStatement ps;
        List<Object> list=new ArrayList<Object>();
        
        DataLoader dataLoader = new DataLoader();
        
        String st = new String("SELECT * FROM artists");
        
                        try
                        {
                        Connection conn = DBConnection.getConnection();

                            ps = conn.prepareStatement(st);
                            ResultSet rs;
                            rs = ps.executeQuery();
                            while (rs.next())
                            {
                                i=i+1;  //zliczanie rekordow w tabeli
                            }
                            randomID=new Random();
                            id = randomID.nextInt((i-1) + 1) + 1;
                            
                            imiona=dataLoader.getNames();
                            randomName = new Random();
                            name = imiona.get(randomName.nextInt(imiona.size()));
                            
                            nazwiska=dataLoader.getSurnames();
                            randomSurname = new Random();
                            surname = nazwiska.get(randomSurname.nextInt(nazwiska.size()));
                            
                            randomAge = new Random();
                            age = randomAge.nextInt((80-20) + 1) + 20;
                            //System.out.println("Zmieniono dane artysty na:"+name+" "+surname+", wiek:"+age);
                            conn.close();
                            rs.close();
                            System.out.println(id);
                        }
                        catch(SQLException e){System.out.println(e);}
                        catch(ClassNotFoundException e){System.out.println(e);}
                        
        
        list.add(id);
        list.add(name);
        list.add(surname);
        list.add(age);
                
        return list;
    }
}
