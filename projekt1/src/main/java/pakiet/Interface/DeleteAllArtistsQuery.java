/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.Interface;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Praktyki
 */
public class DeleteAllArtistsQuery {
    public void execute(Query query, List<Object> parameters) 
    {
    try
        {
            PreparedStatement q;
                q = QueryHelper.getPreparedStatement(query, parameters);
                q.executeQuery();
                q.close();
        }
        catch(SQLException e){ System.out.println(e);}
    }
}
