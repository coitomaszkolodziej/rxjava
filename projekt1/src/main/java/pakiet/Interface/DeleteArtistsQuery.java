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
public class DeleteArtistsQuery implements Executable{
    public void execute(Query query, List<Object> parameters) {
        //throw new UnsupportedOperationException("Not supported yet."); ????????????????????????????????????????????
        //To change body of generated methods, choose Tools | Templates.
        try
        {
            PreparedStatement q;
            //for(int i=1;i<50;i++)
            //{
                q = QueryHelper.getPreparedStatement(query, parameters);
             //   q.setInt(1, i);
                q.executeQuery();
                q.close();
            //}
        }
        catch(SQLException e){ System.out.println(e);}
       
    }
}
