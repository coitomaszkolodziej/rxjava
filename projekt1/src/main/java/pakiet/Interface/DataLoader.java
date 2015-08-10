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
public class DataLoader {
    
    public List<String> getNames() {
        return loadFromFile("names.txt");
    }
    
    public List<String> getSecondNames() {
        
    }
    
    private List<String> loadFromFile(final String fullFilePath) {
        
    }
    
}
