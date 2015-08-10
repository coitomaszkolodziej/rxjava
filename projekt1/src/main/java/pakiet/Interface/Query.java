/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakiet.Interface;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Praktyki
 */
public enum Query {
    
    GET_ARTISTS("SELECT artist_id FROM artists"),
    UPDATE_ARTISTS("UPDATE artists SET artist_name=:artist_name WHERE artist_id=?"),
    DELETE_ARTISTS("DELETE FROM artists WHERE artist_id BETWEEN 1 AND 500"),
    DELETE_ALL_ARTISTS("DELETE FROM artists"),
    INSERT_INTO_ARTISTS("INSERT INTO artists (artist_id,artist_name) VALUES (?,?)");
    
    
    private final String sql;

    Query(final String sql) {
        this.sql = sql;
    }
    
    public String getSql() {
        return sql;
    }
    
    
    
    
}
