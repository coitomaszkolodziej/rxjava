/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi.queries;

import com.google.common.collect.Lists;
import pl.gov.coi.DataLoader;
import pl.gov.coi.Random;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Praktyki
 */
public class InsertArtistQuery implements Executable {

    public void execute() throws SQLException {
        Query.getPreparedStatement(Query.INSERT_ARTIST, getRandomParameters()).execute();
        //Query.getPreparedStatement(Query.INSERT_ARTIST, getRandomParameters()).execute();
        //Query.RX(Query.INSERT_ARTIST);
    }

    private List<Object> getRandomParameters() {
        List<Object> params = Lists.newArrayList();
        params.add(Random.getStringValue(DataLoader.getInstance().getNames()));
        params.add(Random.getStringValue(DataLoader.getInstance().getSurnames()));
        params.add(Random.getIntValue());
        return params;
    }

}
