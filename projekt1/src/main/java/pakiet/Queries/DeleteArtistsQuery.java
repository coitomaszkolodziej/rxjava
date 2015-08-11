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
import pakiet.DBConnection;

/**
 *
 * @author Praktyki
 */
public class DeleteArtistsQuery implements Executable{
    public void execute(Query query, List<Object> parameters) {
        //To change body of generated methods, choose Tools | Templates.
        int id=(Integer) parameters.get(0);
        try
        {
            PreparedStatement q;
                q = QueryHelper.getPreparedStatement(query, parameters);
                
                q.setInt(1,id);
                
                q.executeQuery();
                q.close();
        }
        catch(SQLException e){}
    }
    
    
    public List<Object> insertIntoList()
    {
    List<Object> list=new ArrayList<Object>();
    
    int id=0,i=0;
    Random randomID;
    PreparedStatement ps;
    
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
                        System.out.println(id);
                        conn.close();
                        rs.close();
                    }
                    catch(SQLException e){System.out.println(e);}
                    catch(ClassNotFoundException e){System.out.println(e);}
    
    list.add(id);
    return list;
    }
}