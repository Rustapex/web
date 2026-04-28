package movie;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/movie/home")
public class MovieHomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ArrayList<Movie> list = (ArrayList<Movie>) session.getAttribute("movieList");
		
//		System.out.println("home servlet list = " + list);
//		System.out.println("home servlet size = " + (list == null ? "null" : list.size()));
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/movie/home.jsp").forward(req, resp);
		
	}

}
