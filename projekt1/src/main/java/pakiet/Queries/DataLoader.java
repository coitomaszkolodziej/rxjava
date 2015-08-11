/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.Queries;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Praktyki
 */
public class DataLoader {
    
    public List<String> getNames() {
        return loadFromFile("C:\\Users\\Praktyki\\Desktop\\InputData\\names.txt");
    }
    
    public List<String> getSurnames() {
        return loadFromFile("C:\\Users\\Praktyki\\Desktop\\InputData\\surnames.txt");
    }
    
    private List<String> loadFromFile(final String fullFilePath) {
        List<String> dataList = new ArrayList<String>();
        BufferedReader dataReader;
        String data;
        try
        {
            dataReader = new BufferedReader(new FileReader(fullFilePath));
            data = dataReader.readLine();
            while( data != null ) 
                 {
                  dataList.add(data);
                  data = dataReader.readLine();
                 }
        }
        catch(FileNotFoundException e){}
        catch(IOException e){}
        return dataList;
    }
    
}
