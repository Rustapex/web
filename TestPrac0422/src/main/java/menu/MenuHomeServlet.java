package menu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class MenuHomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		ArrayList<Menu> list = (ArrayList<Menu>) session.getAttribute("menuList") ;
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/menu/home.jsp").forward(req, resp);
	}
}
