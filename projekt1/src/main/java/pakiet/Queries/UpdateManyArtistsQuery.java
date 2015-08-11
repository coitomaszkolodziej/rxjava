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
import java.util.List;
import pakiet.DBConnection;

/**
 *
 * @author Praktyki
 */
public class UpdateManyArtistsQuery {
    final List<String> names = new DataLoader().getNames();
    
    public void update(int ile) {
        /*int i=1;
        
        String st = new String("SELECT * FROM artists");
        PreparedStatement ps;
        try
        {
            Connection conn = DBConnection.getConnection();
            ps = conn.prepareStatement(st);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next())
            {
                i=i+1;
            }
        }
        catch(SQLException e){}
        catch(ClassNotFoundException e){}
        
        final int allArtistsCount=i;*/
        
        for (int j = 0; j < ile; j++) 
        {
            new UpdateArtistsQuery().execute(Query.UPDATE_ARTIST, getRandomData());
        }
    }
    
    private List<Object> getRandomData() {
        return new UpdateArtistsQuery().insertIntoList();
   }
    
}
