/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Praktyki
 */
@Getter
public class DataLoader {

    public static DataLoader dataLoader = null;

    public List<String> names;
    public List<String> surnames;

    private DataLoader() {
        names = loadNames();
        surnames = loadSurnames();
    }

    public static DataLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    private static List<String> loadNames() {
        String resourceName = "src/main/resources/files/names.txt";
        return loadFromFile(resourceName);
    }

    private static List<String> loadSurnames() {
        String resourceName = "src/main/resources/files/surnames.txt";
        return loadFromFile(resourceName);
    }

    private static List<String> loadFromFile(final String fullFilePath) {
        List<String> dataList = new ArrayList<String>();
        BufferedReader dataReader;
        String data;
        try {
            dataReader = new BufferedReader(new FileReader(fullFilePath));
            data = dataReader.readLine();
            while (data != null) {
                dataList.add(data);
                data = dataReader.readLine();
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return dataList;
    }

}
