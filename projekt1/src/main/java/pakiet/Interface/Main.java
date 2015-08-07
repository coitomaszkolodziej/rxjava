package pakiet.Interface;

import java.util.LinkedList;

public class Main 
{
    public static void main(String[] args)
    {
        Interface javaObject = new Java();
        
        //javaObject.groupArtistQuery();

        /*LinkedList<GetArtistsID> list=null;
       
	list = javaObject.getArtistsQuery();
	for(GetArtistsID p:list)
            {
		System.out.println(p.getId());
            }*/
        
       //javaObject.insertArtistsQuery(25000);
       //javaObject.deleteArtistsQuery(0000,5000);
       //javaObject.updateArtistQuery(350);
        javaObject.deleteAllArtists();
    }
}
