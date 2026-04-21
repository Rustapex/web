package hotel.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomGradeDAO {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	public Connection dbcon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			 
			if(con !=null) {
				System.out.println("db ok");
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
		
	}
	
	public void close(AutoCloseable ...autoCloseables) {
		for(AutoCloseable a : autoCloseables) {
			if(a != null)
				try {
					a.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	// 전체 조회(방 등급)
	public ArrayList<RoomGrade> selectAll(){
		ArrayList<RoomGrade> list = null;
		list = new ArrayList<>();
		
//		db 연결
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		try {
			String sql = "select * from RoomGrade";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
				String roomgrade_num = rs.getString(1);
				String room_name = rs.getString(2);
				int price = rs.getInt(3);
				String  hotel_id = rs.getString(4);
				
				RoomGrade roomGrade = new RoomGrade(roomgrade_num, room_name, price, hotel_id );
				list.add(roomGrade);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			close(rs,pst,con);
		}
		
		
		return list;
		
	}
	
	// 하나 조회
	public RoomGrade selectOne(String roomgradeNum) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet   rs  = null;
		RoomGrade roomGrade = null;
		String sql = "select * from RoomGrade where roomgrade_num = ? ";
		
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, roomgradeNum);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String TroomgradeNum = rs.getString(1);
				String room_name = rs.getString(2);
				int price = rs.getInt(3);
				String hotel_id = rs.getString(4);
				
				roomGrade = new RoomGrade(TroomgradeNum, room_name, price, hotel_id );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs,pst,con);
		}
		return roomGrade;
		
	}
	
//	등록하기
	public int insert(RoomGrade roomGrade) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		int resultRow =0;
		String sql = "insert into RoomGrade(roomgrade_num, room_name, price,hotel_id) values(?,?,?,?)";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,roomGrade.getRoomgrade_num());
			pst.setString(2,roomGrade.getRoom_name());
			pst.setInt(3,roomGrade.getPrice());
			pst.setString(4,roomGrade.getHotel_id());
			
			resultRow = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pst,con);
		}
		return resultRow;
		
	}
	
//	수정하기
	public int update(RoomGrade roomGrade) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		int resultRow =0;
		String sql ="Update RoomGrade set room_name =?, price =? where roomgrade_num = ?";
		
		try {
			pst= con.prepareStatement(sql);
			
			pst.setString(1, roomGrade.getRoom_name());
			pst.setInt(2, roomGrade.getPrice());
			pst.setString(3, roomGrade.getRoomgrade_num());
			
			resultRow = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pst,con);
		}
		return resultRow;
		
	}
	
//	삭제하기
	public int delete(String roomgradeNum) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		int resultRow = 0;
		String sql = "delete from RoomGrade where roomgrade_num = ?";
		
		try {
			pst= con.prepareStatement(sql);
			
			pst.setString(1, roomgradeNum);
			resultRow = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pst,con);
		}
		return resultRow;
		

	}

}
