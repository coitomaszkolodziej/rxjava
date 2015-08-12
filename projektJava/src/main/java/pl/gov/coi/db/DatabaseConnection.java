package pl.gov.coi.db;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {

    private static DatabaseConnection databaseConnection = null;

    @Getter
    private Connection connection = null;

    private static final String url = "jdbc:postgresql://127.0.0.1:5432/artistsandsongs";
    private static final String password = "admin";
    private static final String username = "admin";

    private DatabaseConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }

}