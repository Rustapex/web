package hotel.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//테이블(acorntbl) 하나당  DAO 한 개 만든다
public class AcornDAO {

	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	
	public Connection dbcon() {		
		Connection con=null;
		try {
			Class.forName(driver);
			con  =DriverManager.getConnection(url, user, password);
			if( con != null) System.out.println("db ok");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;		
	}		
	//학생정보 조회	
	public  ArrayList<HotelCustomer> selectAll(){		
		ArrayList<HotelCustomer> list= null;
		list = new ArrayList<>();		
		//db연결
		 Connection con  =dbcon();
		 PreparedStatement pst= null;
		 ResultSet  rs = null;
		 
		 try {
			//sql작성
			 String sql="select * from Hotel_Customer";
			 pst= 	con.prepareStatement(sql);
			 rs= pst.executeQuery();
			 
			 while( rs.next()) {
				 System.out.println( rs.getString(1));
				 String customer_id = rs.getString(1);
				 String name = rs.getString(2);
				 String tel = rs.getString(3);
				 HotelCustomer hc = new HotelCustomer( customer_id, name, tel);
				 list.add(hc);				 
			 }			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		//실행된 결과 	 
		 close( rs, pst, con);
		return list;		
	}
	
	
	//등록 
	public void  insertMember(HotelCustomer newHC) {		 		
		Connection  con =dbcon();	
		PreparedStatement pst= null;
		
		//sql
		String sql=" insert  into  Hotel_Customer(customer_id, name, tel)  values(?,?,?) ";	
		
		try {
			   pst =con.prepareStatement(sql);
			
			pst.setString(1,  newHC.getCustomer_id());
			pst.setString(2,  newHC.getName());
			pst.setString(3,  newHC.getTel());			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close( pst, con);
		
		
	}	
	
	
	
	// 
	public HotelCustomer selectOne( String id) {		
		//연결
		Connection con  =dbcon();
		PreparedStatement pst  =null;
		ResultSet   rs  = null;
		
		
		//sql
		String  sql=" select * from Hotel_Customer where customer_id  =? ";		
		HotelCustomer hc = null;
		try {
			 pst=con.prepareStatement(sql);
			pst.setString(1, id);			
			 rs = pst.executeQuery();			
			
			if( rs.next()) {
				//id 존재하면
				String customer_id  = rs.getString(1);
				String name =  rs.getString(2);
				String tel = rs.getString(3);				
				hc = new HotelCustomer( customer_id , name, tel);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		close(rs, pst, con);
		return hc;		
	}
	
		
	public void update( String customer_id, String name, String tel) {
		Connection  con  =dbcon();		
		PreparedStatement pst = null;
		
		
		String sql= " update  Hotel_Customer set  name =?, tel =?  where customer_id= ? ";		
		try {
			 pst  =con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, tel);
			pst.setString(3, customer_id);
			
			pst.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		close( pst, con);
	}		
	
	
	
	
	public void delete( String customer_id ) {
		Connection  con  =dbcon();		
		String sql= " delete from  Hotel_Customer where  customer_id= ? ";		
		PreparedStatement pst  = null;
		try {
			pst  =con.prepareStatement(sql);		 
			pst.setString(1, customer_id);
			
			pst.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		close( pst, con);
	}		
	//변경	
//	public static void main(String[] args) {
//		AcornDAO  dao = new AcornDAO();
//		dao.dbcon();
//		ArrayList<HotelCustomer> list  =dao.selectAll();
//		for( HotelCustomer hc : list) {
//			System.out.println(hc);
//		}
//		Acorn acorn = new Acorn("zzz","0000","고길동");
//		dao.insertMember(acorn);		
//		HotelCustomer a = dao.selectOne("sj");
//		System.out.println( a);		
//		dao.update("sj", "4545");
//	}
//	
	

	public void close(AutoCloseable... a) {
	    for (AutoCloseable item : a) {
	        try {
	            if (item != null) item.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
}
