package pakiet.Queries;


import java.util.List;
import java.util.ArrayList;

public class Main 
{
    public static void main(String[] args)
    {
        List<Object> list = new ArrayList<Object>();
        /*Executable insertJavaObject = new InsertArtistsQuery();
        list=insertJavaObject.insertIntoList();
        insertJavaObject.execute(Query.INSERT_INTO_ARTISTS,list);*/
        
        /*Executable updateJavaObject = new UpdateArtistsQuery();
        list=updateJavaObject.insertIntoList();
        updateJavaObject.execute(Query.UPDATE_ARTISTS,list);*/
        
        
        /*UpdateManyArtistsQuery javaObjects = new UpdateManyArtistsQuery();
        javaObjects.update(4000);*/
        
        /*InsertManyArtistsQuery javaObjects = new InsertManyArtistsQuery();
        javaObjects.insert(1000);*/
        
        /*Executable javaObjects = new DeleteArtistsQuery();
        list=javaObjects.insertIntoList();
        javaObjects.execute(Query.DELETE_ARTISTS, list);*/
        
        DeleteManyArtistsQuery javaObject = new DeleteManyArtistsQuery();
        javaObject.delete(3000);
        
    }
    
}
