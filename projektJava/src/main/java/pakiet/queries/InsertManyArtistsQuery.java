/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.queries;

import java.util.List;

/**
 *
 * @author Praktyki
 */
public class InsertManyArtistsQuery 
{
    public void insert(int ile) {
        for (int j = 1; j <= ile; j++) 
        {
            new InsertArtistsQuery().execute(Query.INSERT_INTO_ARTISTS, getRandomData());
        }
    }
    
    private List<Object> getRandomData() {
        return new InsertArtistsQuery().insertIntoList();
   }
}
