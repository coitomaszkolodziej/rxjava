/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi.queries.getArtists;

import com.google.common.collect.Lists;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pl.gov.coi.DataLoader;
import pl.gov.coi.Random;
import pl.gov.coi.db.DatabaseConnection;
import pl.gov.coi.queries.Query;

/**
 *
 * @author Praktyki
 */
public class GetArtistQuery {
    public void execute() throws SQLException {
        Query.getPreparedStatement(Query.GET_ARTISTS, getRandomParameters()).execute();
        //Query.RX(Query.INSERT_ARTIST);
    }

    private List<Object> getRandomParameters() throws SQLException {
        List<Object> params = Lists.newArrayList();
        params.add(Random.getStringValue(DataLoader.getInstance().getNames()));
        //System.out.println(params);
        return params;
    }
}
