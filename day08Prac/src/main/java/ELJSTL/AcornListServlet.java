package ELJSTL;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/acornList")
public class AcornListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AcornService service = new AcornService();
		ArrayList<Acorn> list = service.getMemberList();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/acornList.jsp").forward(req, resp);
	}
}
