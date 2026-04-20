package day04Prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;



/*
 * 1. oracle driver library 해당 위치에 두기
 * 2. Class.forName() class loading
 * 3. DriverManager를 통해서 DB 연결 - 연결정보, 사용자, 비밀번호, url => Connection 객체를 반환 받음
 * 4. 문장 얻어오기 PreparedStatement 얻어오기
 * 5. sql 쿼리 작성하기 
 * 6. sql 실행하기 , 조회
 * 7. 실행 결과 자바 객체로 만들기 (ArrayList<Acorn>, Acorn)
 */

// DAO 한 개 -> DATE 한 개
//Join 같은 경우는 ? 중심 테이블에 두면 된다.
public class AcornDAO {
	//
	String driver ="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";  // system
	String password="tiger"; //1234
	
//	db 연결
//	반환 : 연결객체 / 입력 : x
	public Connection dbcon() {
		Connection con = null;
		try {
			Class.forName(driver);
			try {
				con = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return con;
	}
	
	public static void main(String[] args) {
//		AcornDAO dao = new AcornDAO();
//		Connection con = dao.dbcon(); // 올바른 연결 반환 ok, null 반환 fail - 연결
//		System.out.println(con);
//		
//		if(con != null) {
//			System.out.println("DB 오케이");
//		}
		
//		AcornDAO dao = new AcornDAO();
//		ArrayList<Acorn> list = dao.SelectAll();
//		
//		System.out.println(list);
		
		AcornDAO dao = new AcornDAO();
		
		Acorn acorn = dao.selectOne("sys");
		System.out.println(acorn);
		
	}
	
//	전체 조회 (페이징)
	public ArrayList<Acorn> SelectAll(){
		
//		db 연결
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from acorntbl";
		
		ArrayList<Acorn> list = new ArrayList<>(); // 준비
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
		
			while(rs.next()) { // rs -> 한 생(테이블의 레코드 값이 담겨 있음)
//				System.out.println(rs.getString(1));
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int point = rs.getInt(4);
				java.util.Date birth = rs.getDate(5);
				
				Acorn acorn = new Acorn(id, pw, name, point, birth);
				list.add(acorn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
//			// 자원 정리 로꾸거 ( con -> pst -> rs / 정리 순서 : rs > pst > con)
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if(pst != null) {
//				try {
//					pst.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if(con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			
			close(rs, pst,con);
		}
		return list;
	}
	
	
//	close 하기 메서드
//	3 개의 객체는 모두 AutoCloseable interface 를 구현하였다.
//	입력 : connection, preparedStatement, ReseultSet => 타입의 객체, 가변인자
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
	
	
//	한 개 조회
	public Acorn selectOne(String id) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Acorn acorn = null;
		String sql = "select * from acorntbl where id=?";
		
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,id);
			rs = pst.executeQuery();
			
			if(rs.next()) { // 조회 결과 가져오기 , true => 해당 id 데이터 존재 
				
				
				String tid = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int point = rs.getInt(4);
				java.util.Date birth = rs.getDate(5);
				acorn = new Acorn(tid, pw, name, point, birth);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs,pst,con);
		}
		return acorn;
	}	
	
//	등록하기
	public int insertMember(Acorn acorn) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		int resultRow =0;
		String sql = "insert into acorntbl(id, pw,name,point) values(?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, acorn.getId());
			pst.setString(2, acorn.getPw());
			pst.setString(3, acorn.getName());
			pst.setInt(4, acorn.getPoint());
			
			resultRow = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pst,con);
		}
		
		
		return resultRow;
	}
	
	
//	회원 등록 시 -회원취미 	취미
	
//	변경하기
	public int updateMember(Acorn acorn) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		int resultRow =0;
		String sql = "Update acorntbl set pw=?, point =? where id = ?";
		try {
			pst = con.prepareStatement(sql);
			
			pst.setString(1, acorn.getPw());
			pst.setInt(2, acorn.getPoint());
			pst.setString(3, acorn.getId());
			
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
	public int deleteMember(Acorn acorn) {
		Connection con = dbcon();
		PreparedStatement pst = null;
		int resultRow = 0;
		
		String sql = "delete from acorntbl where id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, acorn.getId());
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
