package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExample {

	public static void main(String[] args) {
		
	
	
	Connection con = null;
	PreparedStatement preparedStatement = null;
	
	 
	String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
	String user = "root";
	String password = "asd123";
	
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url,user,password);
		
		String query = "DELETE from employee where id = ? " ;
        
		
		preparedStatement = con.prepareStatement(query);
		
		preparedStatement.setInt(1, 7);
			
		int rowCount = preparedStatement.executeUpdate();
		System.out.println("rowCount : " + rowCount);
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}
	
}
