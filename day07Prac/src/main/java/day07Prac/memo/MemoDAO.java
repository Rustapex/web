package day07Prac.memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemoDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	public Connection dbcon() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public ArrayList<Memo> findAll(){
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "select * from memo_tbl";
		
		ArrayList<Memo> list = new ArrayList<>();
		
		return list;
		
	}
	public Memo findById(String memoId) {
		return null;
	}
	public int insert(Memo memo) {
		return 0;
	}
	public int update(Memo memo) {
		return 0;
	}
	public int delete(String memoId) {
		return 0;
	}

}
