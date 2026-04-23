package memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemoDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";
	
	public Connection dbCon() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if(con !=null) System.out.println("db ok");
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
		Connection con = dbCon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "select * from memo_tbl";
		ArrayList<Memo> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String memoId = rs.getString(1);
				String content = rs.getString(2);
				Memo memo = new Memo(memoId, content);
				
				list.add(memo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!= null) rs.close();
				if(pst!= null) pst.close();
				if(con!= null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
		
	}

}


