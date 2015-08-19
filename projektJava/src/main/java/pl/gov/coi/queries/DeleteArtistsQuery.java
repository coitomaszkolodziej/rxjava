/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi.queries;

import java.sql.SQLException;

/**
 *
 * @author Praktyki
 */
public class DeleteArtistsQuery implements Executable{
    
    public void execute() throws SQLException 
    {
        for (int j = 1; j <= 1; j++) 
        {
           new DeleteArtistQuery().execute();
        }
    }
}
