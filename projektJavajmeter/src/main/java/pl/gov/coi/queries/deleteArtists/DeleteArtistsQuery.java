/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi.queries.deleteArtists;

import java.sql.SQLException;
import pl.gov.coi.queries.Executable;

/**
 *
 * @author Praktyki
 */
public class DeleteArtistsQuery implements Executable{
    
    public void execute() throws SQLException 
    {
        for (int j = 1; j <= 100; j++) 
        {
           new DeleteArtistQuery().execute();
        }
    }
}
