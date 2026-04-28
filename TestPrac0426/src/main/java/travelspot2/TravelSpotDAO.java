package travelspot2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TravelSpotDAO {
	
	String driver;
	String url;
	String user;
	String password;
	
	public Connection dbcon() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if(con!= null) System.out.println("db ok");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public ArrayList<TravelSpot> findAll(){
		Connection con = dbcon();
		PreparedStatement pst= null;
		ResultSet rs = null;
		
		String sql = "select * from travel_spot_tbl order by spot_id";
		ArrayList<TravelSpot> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String code= rs.getString(1);
				String name = rs.getString(2);
				String area = rs.getString(3);
				
				TravelSpot ts = new TravelSpot(code,name,area);
				list.add(ts);
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
