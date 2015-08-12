/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    int id=0;
    PreparedStatement psRandom;
    
    String stmt = new String("SELECT artist_id FROM artists ORDER BY RANDOM() LIMIT 1");    
                    try
                    {
                    Connection conn = DBConnection.getConnection();
                        psRandom=conn.prepareStatement(stmt);
                        ResultSet rsRandom;
                        rsRandom = psRandom.executeQuery();
                        while (rsRandom.next())
                        {
                                id = (Integer) rsRandom.getObject(1);      
                        }
                        //System.out.println(id);
                        conn.close();
                        rsRandom.close();
                    }
                    catch(SQLException e){System.out.println(e);}
                    catch(ClassNotFoundException e){System.out.println(e);}
    
    list.add(id);
    return list;
    }
}