package travelspot2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travelSpot.TravelspotService;

@WebServlet("/travelspot/list")
public class TravelSpotListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TravelSpotService service = new TravelSpotService();
		ArrayList<TravelSpot> spotList = service.getTravelSpotList();
		
		req.setAttribute("spotList", spotList);
		
		req.getRequestDispatcher("/WEB-INF/views/travelspot2/list.jsp").forward(req, resp);
		
		
	}

}
