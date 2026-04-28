package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	
	public Connection dbcon() {		 
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			if( con != null) System.out.println( "ok");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;		 	
	}
	
	//
	
	public ArrayList<Member>  findAll(){
		
		Connection con  = dbcon();
		String sql=" select * from  member_tbl_11 ";
		PreparedStatement   pst= null;
		ResultSet  rs = null;
		
		ArrayList<Member> list  = new ArrayList<>();
		
		try {
			pst=con.prepareStatement(sql);			
			rs  =pst.executeQuery();			
			
			//쿼리결과를  ArrayList<Member>만들어서 반환하기 
			while( rs.next()) {
				
			  String m_id = rs.getString(1);
			  String m_pw  =rs.getString(2);
			  String m_name  = rs.getString(3);
			  String m_tel  = rs.getString(4);
			  String m_birthday  = rs.getString(5);
			  int m_point = rs.getInt(6);
			  String m_grade  = rs.getString(7);			  
			  
			  // Member객체만들고 리스트에 추가하기
			  Member member  = new Member(m_id, m_pw, m_name, m_tel, m_birthday, m_point, m_grade);		  
			  
			  list.add(member);
				
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//
		}
		
		return list;
		
	}
	
	
	
public ArrayList<Member>  findAllPaging( int page, int pageSize){
		//page =>현재페이지
	    //pageSize=>한 페이지의 글의 수 
	// 1 , 4   => 1   4
	// 2  ,4      5    8  
	// 3,  4   => 9    12
	
	    int start = (page-1)*pageSize +1;
	    int end = page* pageSize;
	
	
		Connection con  = dbcon();
		String sql=" select   m_id, m_pw, m_name, m_tel, m_birthday, m_point, m_grade "
				+ "from( "				
				+ "    select  rownum  num,  m_id, m_pw, m_name, m_tel, m_birthday, m_point, m_grade  from member_tbl_11 "
				+ ")"
				+ "where  num  between  ?  and   ? ";
		PreparedStatement   pst= null;
		ResultSet  rs = null;
		
		ArrayList<Member> list  = new ArrayList<>();
		
		try {
			pst=con.prepareStatement(sql);		
			pst.setInt(1, start);
			pst.setInt(2,  end);
			
			rs  =pst.executeQuery();			
			
			//쿼리결과를  ArrayList<Member>만들어서 반환하기 
			while( rs.next()) {
				
			  String m_id = rs.getString(1);
			  String m_pw  =rs.getString(2);
			  String m_name  = rs.getString(3);
			  String m_tel  = rs.getString(4);
			  String m_birthday  = rs.getString(5);
			  int m_point = rs.getInt(6);
			  String m_grade  = rs.getString(7);			  
			  
			  // Member객체만들고 리스트에 추가하기
			  Member member  = new Member(m_id, m_pw, m_name, m_tel, m_birthday, m_point, m_grade);		  
			  
			  list.add(member);
				
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//
		}
		
		return list;
		
	}

public ArrayList<Member> findPaging(int page, int pageSize){
	// page => 현재 페이지
    // pageSize => 한 페이지에 보여줄 글 수

    int start = (page - 1) * pageSize + 1;
    int end = page * pageSize;

    Connection con = dbcon();
    PreparedStatement pst = null;
    ResultSet rs = null;

    String sql = "select m_id, m_pw, m_name, m_tel, m_birthday, m_point, m_grade "
               + "from ( "
               + "    select rownum NUM, m_id, m_pw, m_name, m_tel, m_birthday, m_point, m_grade "
               + "    from member_tbl_11 "
               + ") "
               + "where NUM between ? and ?";

    ArrayList<Member> list = new ArrayList<>();

    try {
        pst = con.prepareStatement(sql);

        pst.setInt(1, start);
        pst.setInt(2, end);

        rs = pst.executeQuery();

        while (rs.next()) {
            String m_id = rs.getString("m_id"); // rs.getString(1)과 같은 의미
            String m_pw = rs.getString("m_pw");
            String m_name = rs.getString("m_name");
            String m_tel = rs.getString("m_tel");
            String m_birthday = rs.getString("m_birthday");
            int m_point = rs.getInt("m_point");
            String m_grade = rs.getString("m_grade");

            Member member = new Member(
                m_id,
                m_pw,
                m_name,
                m_tel,
                m_birthday,
                m_point,
                m_grade
            );

            list.add(member);
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


  // 총레코드 수 

    public int  countAll() {
    	
    	Connection con  = dbcon();    	
    	String sql=" select  count(*) from member_tbl_11";
    	PreparedStatement pst= null;
    	ResultSet  rs = null;
    	int resultCnt=0;
    	
    	try {
			pst= con.prepareStatement(sql);
			rs =pst.executeQuery();
			
			if(rs.next()) {
				resultCnt= rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
		return resultCnt; 
    	
    }


	public static void main(String[] args) {
		MemberDAO  dao = new MemberDAO();
//		int result  =dao.countAll();
//		System.out.println( result );
//		
//		//ArrayList<Member>  list  =dao.findAll();
//	//	System.out.println( list);
//		
//		ArrayList<Member>  list2 =dao.findAllPaging(1,2);
//		System.out.println( list2);
//		
//		
//		for(  Member  m : list2) {
//			System.out.println( m.m_name);
//		}
		
		 ArrayList<Member> list = dao.findPaging(2, 4);

		    System.out.println("=== 2페이지, 한 페이지 4개 조회 ===");

		    for (Member m : list) {
		        System.out.println(m);
		    }
	}
	
	
	
	
}
