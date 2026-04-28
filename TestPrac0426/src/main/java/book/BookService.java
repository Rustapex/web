package book;

import java.util.ArrayList;

public class BookService {
	
	BookDAO dao = new BookDAO();
	
	public ArrayList<Book> getBookList(String sort){
		return dao.selectAll(sort);
	}

}
