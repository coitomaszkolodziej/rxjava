/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.Interface;

import java.util.ArrayList;
import java.util.List;


public interface Executable {
    
    void execute(Query query, List<Object> parameters);
    //public List<Object> getArtistsQuery(Query query);
}
