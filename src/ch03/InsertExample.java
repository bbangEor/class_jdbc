package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydb2?serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "asd123" ;
		
		// connection 객체를 얻어서 insert 구문을 직접 만들어보기 !
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		// mydb2 사용 , employee 테이블에 값을 넣는 코드를 작성하세요

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);

			String query = "insert into employee values( ?, ?, ?, ?, now())";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 7);
			preparedStatement.setString(2, "이순신");
			preparedStatement.setString(3, "IT");
			preparedStatement.setString(4, "5000000.00");

			// 실행에 호출은 executeQuery 에 사용
			int rowCount = preparedStatement.executeUpdate();
			System.out.println("rowCount : " + rowCount);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
