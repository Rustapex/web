package day05Prac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import day05Prac.dto.Acorn;

public class AcornDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";
	
	// db 연결
	public Connection dbcon() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void main(String[] args) {
		AcornDAO dao = new AcornDAO();
		Connection con = dao.dbcon();
		
		System.out.println(con);
		if (con != null) {
			System.out.println("db ok");
		}
	}
	
	// 전체 조회
	public ArrayList<Acorn> selectAll() {
		ArrayList<Acorn> list = new ArrayList<Acorn>();
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "select * from acorntbl";
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int point = rs.getInt(4);
				java.util.Date date = rs.getDate(5);
				
				Acorn acorn = new Acorn(id, pw, name, point, date);
				list.add(acorn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	// 한 명 조회
	public Acorn findById(String id) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Acorn acorn = null;
		
		String sql = "select * from acorntbl where id = ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				String tid = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int point = rs.getInt(4);
				java.util.Date date = rs.getDate(5);
				
				acorn = new Acorn(tid, pw, name, point, date);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return acorn;
	}
	
//	등록하기
	public int insert(Acorn acorn) {
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		int resultRow = 0;
		
		String sql="insert into acorntbl(id,pw,name,point,birthday) values(?,?,?,?,?)";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, acorn.getId());
			pst.setString(2, acorn.getPw());
			pst.setString(3, acorn.getName());
			pst.setInt(4, acorn.getPoint());
			pst.setDate(5, new java.sql.Date(acorn.getBirth().getTime()));
			// java.sql.Date(자식)	-- java.util.Date(부모) <상속 관계>
//			java.sql.Date sqlBirth  =   new  java.sql.Date( acorn.getBirth().getTime());
			
			resultRow = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(pst != null) pst.close();
					if(con !=null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return resultRow;
	}
	
//	수정하기
	public int update(Acorn acorn) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		int ResultRow = 0;
		String sql = "update acorntbl set pw =?, point=? where id=?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, acorn.getPw());
			pst.setInt(2, acorn.getPoint());
			pst.setString(3, acorn.getId());
			
			ResultRow = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pst!= null) pst.close();
				if(con!= null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ResultRow;
	}
	
	public int delete(String id) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		int resultRow = 0;
		String sql="delete from acorntbl where id= ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			
			resultRow = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(pst !=null)pst.close();
					if(con !=null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return resultRow;
	}
}