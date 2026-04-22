package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	  String url="jdbc:oracle:thin:@localhost:1521:testdb";
	  String user="scott";
	  String password="tiger";
	  
	  public Connection dbcon() {
		  Connection con = null;
		  try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if(con!=null) System.out.println("db ok");
			
		  } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		  
		  
	  }
	  
	  public ArrayList<Hotel> selectAll(){
		  Connection con = dbcon();
		  PreparedStatement pst = null;
		  ResultSet rs = null;
		  String sql = "select * from Hotel";
		  ArrayList<Hotel> list = new ArrayList<>();
		  
		  try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String hotelId = rs.getString(1);
				String hotelName = rs.getString(2);
				int hotelStar = rs.getInt(3);
				
				Hotel hotel = new Hotel(hotelId, hotelName,hotelStar);
				list.add(hotel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(rs !=null) rs.close();
					if(pst != null) pst.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		  return list;
		  
	  }
	  
	  public int registerHotel(Hotel newHotel) {
		  Connection con = dbcon();
		  PreparedStatement pst = null;
		  int resultRow = 0;
		  
		  String sql = "insert into Hotel(hotelId, hotelName, hotelStar) values(?,?,?)";
		  
		  
		  try {
			pst = con.prepareStatement(sql);
			pst.setString(1, newHotel.getHotelId());
			pst.setString(1, newHotel.getHotelName());
			pst.setInt(1, newHotel.getHotelStar());
			
			resultRow = pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		  
		  return resultRow;
	  }

}
