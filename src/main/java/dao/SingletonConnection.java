package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
   
	private static Connection connection ;
	
	static {
		try {
	        Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	        System.err.println("Where is your PostgreSQL JDBC Driver? "
	                + "Include in your library path!");
	        e.printStackTrace();
	    }
		
		try {
	        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/produits", "postgres", "haitam");

	    } catch (SQLException e) {
	        System.err.println("Connection Failed! Check output console");
	        e.printStackTrace();
	    }
		
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
