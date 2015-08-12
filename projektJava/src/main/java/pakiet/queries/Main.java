package pakiet.queries;


import java.util.List;
import java.util.ArrayList;

public class Main 
{
    public static void main(String[] args)
    {
        List<Object> list = new ArrayList<Object>();

        UpdateManyArtistsQuery javaObjects = new UpdateManyArtistsQuery();
        javaObjects.update(15);
        
        /*InsertManyArtistsQuery javaObjects = new InsertManyArtistsQuery();
        javaObjects.insert(25);*/
        
        /*DeleteManyArtistsQuery javaObject = new DeleteManyArtistsQuery();
        javaObject.delete(50);*/
        
    }
    
}
