package pakiet.Interface;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import aaa.*;
public class Main 
{
    public static void main(String[] args)
    {
        /*Interface javaObject=new Java();
        javaObject.groupArtistQuery();

        LinkedList<GetArtistsID> list=null;
       
	list = javaObject.getArtistsQuery();
	for(GetArtistsID p:list)
            {
		System.out.println(p.getId());
            }
        */
        
        Executable javaObject = new InsertArtistsQuery();
        List<Object> list = new ArrayList<Object>();
        list.add(1230);
        list.add("czx");
        //list = javaObject.getArtistsQuery(Query.GET_ARTISTS);
        //javaObject.execute(Query.GET_ARTISTS,list);
        
        //javaObject.execute(Query.UPDATE_ARTISTS,list);
        //javaObject.execute(Query.DELETE_ARTISTS, list);
        
        //javaObject.execute(Query.DELETE_ALL_ARTISTS,list);
        javaObject.execute(Query.INSERT_INTO_ARTISTS,list);
    }
    
   /* public List<Object> insertIntoList(int id)
    {   
        List<Object> list=new ArrayList<Object>();
        list.add(id);
        return list;
    }*/
}
