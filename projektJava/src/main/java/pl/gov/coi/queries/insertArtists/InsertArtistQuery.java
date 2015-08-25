/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi.queries.insertArtists;

import com.google.common.collect.Lists;
import pl.gov.coi.DataLoader;
import pl.gov.coi.Random;

import java.sql.SQLException;
import java.util.List;
import pl.gov.coi.queries.Executable;
import pl.gov.coi.queries.Query;

/**
 * @author Praktyki
 */
public class InsertArtistQuery implements Executable {

    public void execute() throws SQLException {
        Query.getPreparedStatement(Query.INSERT_ARTIST, getRandomParameters()).execute();
        //Query.RX(Query.INSERT_ARTIST);
    }

    private List<Object> getRandomParameters() {
        List<Object> params = Lists.newArrayList();
        params.add(Random.getStringValue(DataLoader.getInstance().getNames()));
        params.add(Random.getStringValue(DataLoader.getInstance().getSurnames()));
        int a=Random.getIntAgeValue();
        params.add(a);
        System.out.println("wiek "+a);
        return params;
    }

}
