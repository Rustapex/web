package menu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/memu/list")
public class MenuListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MenuService service = new MenuService();
		ArrayList<Menu> menuList = service.getMemuList();
		
		HttpSession session = req.getSession();
		session.setAttribute("menuList", menuList);
		
		resp.sendRedirect(req.getContextPath() + "/home");
		
		
		
	}
}
