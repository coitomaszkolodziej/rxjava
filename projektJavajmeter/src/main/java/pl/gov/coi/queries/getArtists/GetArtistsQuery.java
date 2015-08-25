package pl.gov.coi.queries.getArtists;

import java.sql.SQLException;
import pl.gov.coi.queries.Executable;

/**
 * @author Tomasz Ko³odziej
 */
public class GetArtistsQuery implements Executable {

    public void execute() throws SQLException {
        /*
        Uruchamia zapytanie Query.GET_ARTISTS z losowym imieniem.
        Nastepnie przy pomocy petli przechodzi przez wszystkie elementy (i nic nie robi).
         */
        {
        for (int j = 1; j <= 50; j++) 
            {
                new GetArtistQuery().execute();
            }
        }
    }

}
