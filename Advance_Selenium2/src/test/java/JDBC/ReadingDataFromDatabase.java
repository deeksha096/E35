package JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadingDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost::3306/sys,");
		Statement stat=con.createStatement();
		ResultSet result=stat.executeQuery("select * from ninza");
		while(result.next()) {
			System.out.println(result.getString(1)+result.getString(2));
		}

	}

}
