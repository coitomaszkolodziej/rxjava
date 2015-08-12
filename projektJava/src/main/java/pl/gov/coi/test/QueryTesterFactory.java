package pl.gov.coi.test;

import com.google.common.collect.Lists;
import pl.gov.coi.Mode;
import pl.gov.coi.queries.Executable;
import pl.gov.coi.queries.InsertManyArtistsQuery;
import pl.gov.coi.queries.InsertManyArtistsQueryRx;

/**
 * @author Tomasz Ko³odziej
 */
public class QueryTesterFactory {

    private QueryTesterFactory() {

    }

    public static QueryTester getQueryTester(final Mode mode) {
        switch (mode) {
            case DEFAULT: {
                return new QueryTester(Lists.newArrayList(
                        new Executable[]{
                                new InsertManyArtistsQuery(),
                        }
                ));
            }
            case RXJAVA: {
                return new QueryTester(Lists.newArrayList(
                        new Executable[]{
                                new InsertManyArtistsQueryRx(),
                        }
                ));
            }
        }
        throw new RuntimeException("Nie mozna utworzyc queryTestera");
    }

}
