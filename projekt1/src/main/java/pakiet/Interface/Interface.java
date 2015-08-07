package pakiet.Interface;

import java.sql.SQLException;
import java.util.LinkedList;

public interface Interface 
{
    LinkedList<GetArtistsID> getArtistsQuery();
    void groupArtistQuery();
    void insertArtistsQuery(int i) ; //ilosc dodawanych rekordow
    void deleteArtistsQuery(int i,int k); //indeks pierwszego usuwanego rekordu, ilosc usuwanych rekordow
    void updateArtistQuery(int j); //ilosc zmienianych rekordow
    void deleteAllArtists();
}
