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
		
		String s="select first_name,last_name,phone from customer , address where address.address_id = customer_id order by last_name "; //Select query from different tables
		
		
		
		//3)Execute Statement/query
		//stmt.execute(s);
		ResultSet re=stmt.executeQuery(s);
		System.out.println("FIRST_NAME" +"  "+"LAST_NAME"+ "   "+"PHONE");

		
		while(re.next()) {
			String fname=re.getString("FIRST_NAME");
			String lname=re.getString("LAST_NAME");
			String phone=re.getString("PHONE");
			System.out.println(fname +"  "+lname+ "   "+phone);
			
		}
		
		
		
		//close the connection
		
		con.close();
		
		System.out.println("Query executed...");
		
		
	}

}
