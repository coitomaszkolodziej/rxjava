package pl.gov.coi.queries;

import java.sql.SQLException;

/**
 * @author Praktyki
 */
public class InsertArtistsQuery implements Executable {

    public void execute() throws SQLException 
    {
        for (int j = 1; j <= 100; j++) 
        {
           //System.out.println(j);
           new InsertArtistQuery().execute();
        }
    }
    
}
