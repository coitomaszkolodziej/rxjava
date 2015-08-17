package pl.gov.coi;


import pl.gov.coi.test.QueryTesterFactory;

import java.sql.SQLException;

import static com.google.common.base.Preconditions.*;

public class Main {
    public static void main(String[] args) {
        checkArgument(args != null && args.length == 1, "Nie podano argumentu. Dostepne argumenty: " + Mode.values().toString());

        try {
            QueryTesterFactory.getQueryTester(Mode.valueOf(args[0])).run();
        } catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

}
