package pl.gov.coi.test;

import com.google.common.collect.Lists;
import pl.gov.coi.Mode;
import pl.gov.coi.queries.Executable;
import pl.gov.coi.queries.InsertArtistsQuery;
import pl.gov.coi.queries.InsertArtistsQueryRx;

/**
 * @author Tomasz Ko³odziej
 */
public class QueryTesterFactory {

    private QueryTesterFactory() {

    }
    
    public static QueryTester getQueryTester(final Mode mode) {
        switch (mode) {
            case DEFAULT: {
                return new QueryTester(Lists.newArrayList(new Executable[]{
                                new InsertArtistsQuery(),
                        }
                ));
            }
            case RXJAVA: {
                return new QueryTester(Lists.newArrayList(new Executable[]{
                                new InsertArtistsQueryRx(),
                        }
                ));
            }
        }
        throw new RuntimeException("Nie mozna utworzyc queryTestera");
    }

}
