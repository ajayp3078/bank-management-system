package bankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	
	Connection c;
	Statement s;
	
	public Conn() {
		try {
//			Class.forName(com.mysql.cj.jdbc.Driver);	// no need - eclipse picks automatically
			
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","Ajay@1999");
			s = c.createStatement();
			// by default port 3306 : jdbc:mysql:///bankmanagementsystem
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
