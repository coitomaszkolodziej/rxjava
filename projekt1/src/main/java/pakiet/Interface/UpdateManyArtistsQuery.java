/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.Interface;

/**
 *
 * @author Praktyki
 */
public class UpdateManyArtistsQuery {
    final List<String> names = new DataLoader().getNames();
    
    public void run() {
        final int allArtistsCount = 100;
        
        for (int i = 0; i < 100; i++) {
            new UpdateArtistsQuery().execute(Query.GET_ARTISTS, getRandomData());
        }
    }
    
    private List<Object> getRandomData() {
        
    }
    
}
