/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.coi.queries;

import com.github.davidmoten.rx.jdbc.Database;
import pl.gov.coi.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Praktyki
 */
public enum Query {

    DELETE_ARTIST("DELETE FROM artists WHERE artist_id=?"),
    INSERT_ARTIST("INSERT INTO artists (artist_name,artist_surname,artist_age) VALUES (?,?,?)"),
    GET_ARTISTS("SELECT artist_id, artist_name,artist_surname,artist_age FROM artists WHERE artist_name = ?");
    
    
    private final String sql;

    Query(final String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public static PreparedStatement getPreparedStatement(final Query query, final List<Object> parameters) throws SQLException {
        
        final Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(query.getSql());
        int idx = 1;
        for (Object param : parameters) {
            if (param instanceof Integer) {
                ps.setInt(idx, (Integer) param);
            } else if (param instanceof String) {
                ps.setString(idx, (String) param);
            }
            idx++;
        }
        return ps;
    }
    
    public static void RX(final Query query) throws SQLException
    {
        final Connection conn = DatabaseConnection.getInstance().getConnection();
        Database db=new Database(conn);
        db.update(INSERT_ARTIST.getSql()).parameters("A","B",23);
        //List<Integer> id=  db.select("Select artist_id FROM artists").getAs(Integer.class).toList().toBlocking().single();
        //System.out.println(id);
        //System.out.println(query.getSql());
    }
}
