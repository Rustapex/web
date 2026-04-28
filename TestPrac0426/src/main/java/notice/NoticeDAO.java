package notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class NoticeDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user ="scott";
	String password = "tiger";
	
	public Connection dbcon() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if(con != null) System.out.println("db ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return con;
	}
	
	public ArrayList<Notice> selectRecentFive(){
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs= null;
		
		String sql = "select * from notice_tbl order by reg_date desc fetch first 5 rows only";
		ArrayList<Notice> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String notice_id = rs.getString(1);
				String title = rs.getString(2);
				java.util.Date date = rs.getDate(3);
				Notice notice = new Notice( notice_id,  title,  date);
				list.add(notice);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(rs !=null) rs.close();
				if(pst !=null) pst.close();
				if(con !=null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		return list;

	}
}
