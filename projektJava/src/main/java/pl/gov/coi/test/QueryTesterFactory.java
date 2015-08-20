package pl.gov.coi.test;

import com.google.common.collect.Lists;
import pl.gov.coi.Mode;
import pl.gov.coi.queries.deleteArtists.DeleteArtistsQuery;
import pl.gov.coi.queries.deleteArtists.DeleteArtistsQueryRx;
import pl.gov.coi.queries.Executable;
import pl.gov.coi.queries.getArtists.GetArtistsQuery;
import pl.gov.coi.queries.getArtists.GetArtistsQueryRx;
import pl.gov.coi.queries.insertArtists.InsertArtistsQuery;
import pl.gov.coi.queries.insertArtists.InsertArtistsQueryRx;

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
                                //new InsertArtistsQuery(),
                                //new DeleteArtistsQuery(),
                                //new GetArtistsQuery(),
                        }
                ));
            }
            case RXJAVA: {
                return new QueryTester(Lists.newArrayList(new Executable[]{
                                //new InsertArtistsQueryRx(),
                                new DeleteArtistsQueryRx(),
                                //new GetArtistsQueryRx(),
                        }
                ));
            }
        }
        throw new RuntimeException("Nie mozna utworzyc queryTestera");
    }

}
