import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mysql.cj.xdevapi.Statement;

public class EventRegist {
	Scanner scanner = new Scanner(System.in);
	
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://172.16.47.89/testdb:PORT?characterEncoding=UTF-8&serverTimezone=UTC";
	Connection conn;
	
	PreparedStatement pstmt;
	ResultSet rs;	

public EventRegist() {
	System.out.println("## 이벤트 등록을 위해 이름과 나이를 입력하세요.");
	System.out.print("이름: ");
	String username = scanner.next();
	System.out.print("나이: ");
	String age = scanner.next();
	
	connectDB();
	registUser(username, age);
	printList();
	closeDB();
}

public void connectDB() {
	try {
		Class.forName(jdbcDriver);
		
		conn = DriverManager.getConnection(jdbcUrl, "Seoin", "wndeoqnrh1");
	} catch (Exception e) {
		e.printStackTrace();

	}
}
public void closeDB() {
	try {
		pstmt.close();
		rs.close();
		conn.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
}
public void registUser(String username, String age) {
	String sql = "insert into test values(username, age)";
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, age);
		
		pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
public void printList() {
	System.out.println("# 기준자 명단");
	String sql = "selct * from test";
	try {
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("unname")+", "+rs.getString(2));
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}
}

}


