package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	public Connection dbCon() {
		
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if(con!= null) System.out.println("db ok");
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public ArrayList<Book> selectAll(String sort){
		Connection con = dbCon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String orderBy = "book_id";
		if("price".equals(sort) || "stock".equals(sort) || "title".equals(sort)) {
			orderBy = sort;			
		}
		
		
		String sql = "select * from book_tbl order by " + orderBy;
		ArrayList <Book> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String bookId = rs.getString(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				int price = rs.getInt(4);
				int stock = rs.getInt(5);
				
				Book book = new Book(bookId, title, author, price, stock);
				list.add(book);
				
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
