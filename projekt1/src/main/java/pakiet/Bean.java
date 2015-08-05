package pakiet;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class Bean implements Serializable {
	public Bean(){}
							
	public LinkedList<Permission> wynikZapytania() throws SQLException, ClassNotFoundException{
		Connection conn = DBConnection.getConnection();
		String q = new String("SELECT artist_id FROM artists WHERE artist_id BETWEEN 5 AND 15");
		PreparedStatement ps = conn.prepareStatement(q);
		//ps.setInt(1, id);

		LinkedList<Permission> list = new LinkedList<Permission>();
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			list.add(new Permission(rs.getInt(1)));
		
	}
	return list;
}

}