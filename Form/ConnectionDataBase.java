import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class ConnectionDataBase {


public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root");
	return conn;
}
}
