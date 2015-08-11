/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.Queries;

import aaa.GetArtistsID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import pakiet.DBConnection;
import pakiet.Queries.QueryHelper;
import java.util.ArrayList;
/**
 *
 * @author Praktyki
 */
/*public class GetArtistsQuery implements Executable {
    
    public void execute(Query query, List<Object> parameters) {
        
        //To change body of generated methods, choose Tools | Templates.
        try
        {
            PreparedStatement q;
            q = QueryHelper.getPreparedStatement(query, parameters);
            
            q.executeQuery();
            q.close();
        }
        catch(SQLException e){ System.out.println(e);}
        
    }
    
   /*public List<Object> getArtistsQuery(Query query)
    {  
        List<Object> list = new ArrayList<Object>();
        try
        {
                q = QueryHelper.getPreparedStatement(query, list);
                
                ResultSet rs = q.executeQuery();
                
                while(rs.next())
                {
                    list.add(new GetArtistsID(rs.getInt(1)));
                }        
        }
        catch(SQLException e){}
        //catch(ClassNotFoundException e){}
        return list;
    } */
//}
