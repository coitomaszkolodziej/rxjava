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
import java.util.Random;
import pakiet.DBConnection;

/**
 *
 * @author Praktyki
 */
public class RandomValue 
{
    public String randomValue(List<String> list)
    {
        String value="";
        Random random = new Random();
        
        value=list.get(random.nextInt(list.size()));
        return value;
    }
    
    public Boolean checkTable(int id,String st)
    {
        List<Integer> list = new ArrayList<Integer>();
        PreparedStatement ps;
        int i=0;
        try
        {
            Connection conn = DBConnection.getConnection();
            ps=conn.prepareStatement(st);
            ResultSet rs;
            rs = ps.executeQuery();
            while (rs.next())
            {
                i = (Integer) rs.getObject(1);   
                list.add(i);
            }
            for (int el : list)
            {
                if(id!=el)
                    return false;
            }
        }
        catch (SQLException e){}
        catch(ClassNotFoundException e){}
        return true;
    }
}
