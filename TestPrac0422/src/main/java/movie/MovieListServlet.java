package movie;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/movie/list")
public class MovieListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MovieService service = new MovieService();
		ArrayList<Movie> movieList = service.getMovieList();
		
//		System.out.println("MovieList size = " + movieList.size());
		
		HttpSession session = req.getSession();
		session.setAttribute("movieList", movieList);
		
		resp.sendRedirect(req.getContextPath() + "/movie/home");
		
	}

}
