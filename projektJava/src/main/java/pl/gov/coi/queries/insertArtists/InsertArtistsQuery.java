package pl.gov.coi.queries.insertArtists;

import java.sql.SQLException;
import pl.gov.coi.queries.Executable;

/**
 * @author Praktyki
 */
public class InsertArtistsQuery implements Executable {

    public void execute() throws SQLException 
    {
        for (int j = 1; j <= 100; j++) 
        {
           new InsertArtistQuery().execute();
        }
    }
    
}
