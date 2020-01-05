package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class demoDB {
@Test
public void testA() throws SQLException {
	String url = "jdbc:mysql://localhost:3306/sel";
	String un = "mysql_sk";
	String pw = "Anticipate@&90";
	//connect to db
	Connection con = DriverManager.getConnection(url, un, pw);
	//to send the query to db(path)
	Statement stmt = con.createStatement();
	//send the query to db and get the record
	ResultSet res = stmt.executeQuery("select * from EmpInfo where name = 'Raghu'");
	
	while (res.next()) {  //we use while loop so that we dont get the headings column, by default getstring will point to  //collection method next
		String name = res.getString("NAME");
		Reporter.log("Name is : " +name, true);
		String id = res.getString("ID");
		Reporter.log("ID is : " +id, true);
		String dept = res.getString("DEPT");
		Reporter.log("Dept is : " +dept, true);
		String gender = res.getString(4);
		Reporter.log("gender is : " +gender, true);
	}
	//to disconnect
	con.close();
}
}
