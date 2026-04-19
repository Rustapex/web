package hotel.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hotelCustomer")
public class HotelCustomerOneServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String customer_id = req.getParameter("customer_id");
	    System.out.println("넘어온 customer_id = " + customer_id);

	    HotelService service = new HotelService();
	    HotelCustomer hc = service.getMember(customer_id);
	    System.out.println("조회된 hc = " + hc);		
		
		req.setAttribute("hc", hc);
		
		req.getRequestDispatcher("WEB-INF/views/member.jsp").forward(req, resp);
	}

}
