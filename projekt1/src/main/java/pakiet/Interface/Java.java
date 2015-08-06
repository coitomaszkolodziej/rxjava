package pakiet.Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import pakiet.DBConnection;

public class Java implements Interface
{
    public Java(){}
    
    public void groupArtistQuery()
    {
        try
        {
            Connection conn = DBConnection.getConnection();
            String q = new String("SELECT ar.artist_id,ar.artist_surname as NAZWISKO,count(s.song_id) as ILOSC_PIOSENEK\n" +
                            "FROM artists ar, albums al, songs s\n" +
                            "WHERE ar.artist_id=al.album_id AND s.album_id=al.album_id\n" +
                            "GROUP BY ar.artist_id\n" +
                            "ORDER BY ar.artist_id");
            
            PreparedStatement ps = conn.prepareStatement(q);
            ps.executeQuery();
            System.out.println("Grupowanie udane.");
        }
        catch(SQLException e){}
        catch(ClassNotFoundException e){}
    }
    
    public LinkedList<GetArtistsID> getArtistsQuery()
    {  
        LinkedList<GetArtistsID> list = new LinkedList<GetArtistsID>();
        try
        {
        Connection conn = DBConnection.getConnection();
        
                String q = new String("SELECT artist_id FROM artists WHERE artist_id BETWEEN 5 AND 15");
                PreparedStatement ps = conn.prepareStatement(q);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next())
                {
                    list.add(new GetArtistsID(rs.getInt(1)));
                }        
        }
        catch(SQLException e){}
        catch(ClassNotFoundException e){}
        return list;
    }
    
    public void insertArtistsQuery(int i)
    {
        try
        {
         Connection conn = DBConnection.getConnection();
         String st = new String("SELECT COUNT(*) FROM artists");
         PreparedStatement ps1 = conn.prepareStatement(st);
         ResultSet rs = ps1.executeQuery("SELECT COUNT(*) FROM artists");
         ps1.close();
         int j=rs.getInt(1);
         System.out.println(j);
            for(int k=j;j<=k+i;j++)
            {    
            
            String q = new String("INSERT INTO artists (artist_id)\n" +
                                   "VALUES (?)");
            
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setInt(1, j);
           
            ps.execute();
            ps.close();
            
            }
            System.out.println("Dodawanie do tabeli udane.");
            conn.close();
        }
        catch(SQLException e){}
        catch(ClassNotFoundException e){}
    }
    
    public void deleteArtistsQuery(int i,int k)
    {
        try
        {
        Connection conn = DBConnection.getConnection();
            for(int j=i;j<=(i+k);j++)
            {
                String q = new String("DELETE FROM artists\n" +
                                   "WHERE artist_id=?");
            
                PreparedStatement ps = conn.prepareStatement(q);
                ps.setInt(1, j);
           
                ps.execute();
                ps.close();
            }
            System.out.println("Usuwanie rekordow z tabeli udane.");
            conn.close();
                    }
        catch(SQLException e){}
        catch(ClassNotFoundException e){}
    }
}
