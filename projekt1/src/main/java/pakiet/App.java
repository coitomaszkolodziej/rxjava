package pakiet;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
		Bean b = new Bean();
		LinkedList<Permission> list=null;
		try
		{
			list = b.wynikZapytania();
		}
		catch (SQLException e){
			System.out.println(e);
		}
		catch (ClassNotFoundException e){System.out.println(e);}
		for(Permission p:list)
		{
			System.out.println(p.getPermissionId());
		}
    }
}
