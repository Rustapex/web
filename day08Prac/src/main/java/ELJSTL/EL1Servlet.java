package ELJSTL;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/el1")
public class EL1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String data = "EL JOA";
		req.setAttribute("data", data);
		
		req.getRequestDispatcher("/WEB-INF/views/el1.jsp").forward(req, resp);
	}
}
