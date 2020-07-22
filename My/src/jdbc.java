import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//123
public class jdbc {
	
	public static final String URL = "jdbc:mysql://localhost/mysql1?serverTimezone=GMT"+"user=root&password=root";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Success loading Mysql Driver!");;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Error loading Mysql Driver!");
				e.printStackTrace();
			}
			try {
				DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver());
				Connection connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1?serverTimezone=GMT","root","root");
				System.out.println("Success connect Mysql server!");
				Statement stmt = connect.createStatement();
				ResultSet rs =  stmt.executeQuery("select * from app01");
				while(rs.next()) {
					System.out.println(rs.getInt("id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("get data error");
				e.printStackTrace();
			}
			
	}

}
