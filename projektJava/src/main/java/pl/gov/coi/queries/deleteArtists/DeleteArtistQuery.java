/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi.queries.deleteArtists;

import com.google.common.collect.Lists;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pl.gov.coi.Random;
import pl.gov.coi.db.DatabaseConnection;
import pl.gov.coi.queries.Query;

/**
 *
 * @author Praktyki
 */
public class DeleteArtistQuery {
    List<Object> list=new ArrayList<Object>();

    public void execute() throws SQLException {
        Query.getPreparedStatement(Query.DELETE_ARTIST, getRandomParameters()).execute();
    }
    
    private List<Object> getRandomParameters() throws SQLException {
        List<Object> params = Lists.newArrayList();
        Integer num=rowsCounter();
        int i=0;
        int s=Random.getIntValue(list.size());
        i = (Integer)list.get(0);
        /*do
        {
            i=(Random.getIntValue(num));
            
        }while(i!=w);*/
        System.out.println(i);
        params.add(i);
        return params;
    }
    
    private Integer rowsCounter() throws SQLException
    {
        final Connection conn = DatabaseConnection.getInstance().getConnection();
        int id=0,number=0;
        PreparedStatement ps,ps1;
        String st = new String("select artist_id from artists order by artist_id desc limit 1");   
        String stmt = new String("select artist_id from artists order by artist_id");
                        try
                        {
                            ps1=conn.prepareStatement(stmt);
                            ps=conn.prepareStatement(st);
                            ResultSet rs,rs1;
                            rs= ps.executeQuery();
                            rs1=ps1.executeQuery();
                            rs.next();
                            while(rs1.next())
                            {
                                list.add(rs1.getObject(1));
                            }
                            number=((Number) rs.getObject(1)).intValue();
                            rs.close();
                            rs1.close();
                        }
                        catch(SQLException e){System.out.println(e);}
        return number;
        }
}
