/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.Queries;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Praktyki
 */
public enum Query {
    
    GET_ARTISTS("SELECT artist_id FROM artists"),
    UPDATE_ARTIST("UPDATE artists SET (artist_name,artist_surname,artist_age)=(?,?,?) WHERE artist_id=?"),
    DELETE_ARTISTS("DELETE FROM artists WHERE artist_id=?"),
    INSERT_INTO_ARTISTS("INSERT INTO artists (artist_id,artist_name,artist_surname,artist_age) VALUES (?,?,?,?)");
    
    
    private final String sql;

    Query(final String sql) {
        this.sql = sql;
    }
    
    public String getSql() {
        return sql;
    }

}
