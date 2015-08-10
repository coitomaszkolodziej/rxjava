/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import pakiet.DBConnection;
import java.util.ArrayList;
/**
 *
 * @author Praktyki
 */
public final class QueryHelper {
    
    static PreparedStatement ps=null;
    
    private QueryHelper() {
        // do nothing
    }
    
    public static PreparedStatement getPreparedStatement(final Query query, final List<Object> parameters)
    {
    String sql=query.getSql();
    
        try
        {
            Connection conn = DBConnection.getConnection();
            ps=conn.prepareStatement(sql);
            
        }
    catch(SQLException e){}
    catch(ClassNotFoundException e){}
    
    return ps;
    
    }
    
    
    
}
