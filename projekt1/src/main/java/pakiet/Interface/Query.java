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
    
    GET_ARTISTS("SELECT * FROM artists", new ArrayList<Object>());
    
    private final String sql;
    private List<Object> parameters;

    Query(final String sql, final List<Object> parameters) {
        this.sql = sql;
        this.parameters = parameters;
    }
    
    public String getSql() {
        return sql;
    }
    
}
