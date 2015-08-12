package pl.gov.coi.test;

import pl.gov.coi.Random;
import pl.gov.coi.queries.Executable;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tomasz Ko³odziej
 */
public class QueryTester {

    private final List<Executable> executables;

    public QueryTester(final List<Executable> executables) {
        this.executables = executables;
    }

    public void run() throws SQLException {
        for (Executable executable : executables) {
            executable.execute();
        }

        for (int idx = 0; idx < 50; idx++) {
            getRandom().execute();
        }
    }

    private Executable getRandom() {
        return executables.get(Random.getIntValue(executables.size()));
    }

}
