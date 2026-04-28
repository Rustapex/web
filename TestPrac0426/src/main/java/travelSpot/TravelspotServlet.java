package travelSpot;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/travel/list")
public class TravelspotServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		TravelspotService service = new TravelspotService();
		ArrayList<Travelspot> list = service.getTravelspot();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/travelspot/list.jsp").forward(req, resp);
		
	}
}
