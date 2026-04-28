package book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book/list")
public class BookServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		String oSort = req.getParameter("sort");
		
		BookService service = new BookService();
		
		ArrayList<Book> list =service.getBookList(oSort);
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/book/bookList.jsp").forward(req, resp);
		
		
		
	}
}
