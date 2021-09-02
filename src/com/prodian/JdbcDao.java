package com.prodian;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//1)create a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost: 3306/sakila","root","root");
		
		//2)create a statement/query
		Statement stmt = con.createStatement();
		
		//String s = "INSERT INTO ACTOR VALUES(201,'TONY','STARK','2006-02-15 04:34:33')"; //insert query
		
		//String s = "UPDATE ACTOR SET FIRST_NAME='THOR', LAST_NAME='THUNDER' WHERE ACTOR_ID=201"; //Update query
		
		//String s = "DELETE FROM ACTOR WHERE ACTOR_ID=201"; //Delete query
		
		String s="select first_name from actor"; //Select query
		
		
		
		//3)Execute Statement/query
		//stmt.execute(s);
		ResultSet re=stmt.executeQuery(s);
		
		while(re.next()) {
			String fname=re.getString("FIRST_NAME");
			System.out.println(fname);
			
		}
		
		
		
		//close the connection
		
		con.close();
		
		System.out.println("Query executed...");
		
		
	}

}
