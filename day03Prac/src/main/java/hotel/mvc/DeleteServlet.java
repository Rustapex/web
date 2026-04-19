package hotel.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 				
		String customer_id  =request.getParameter("customer_id");
		 
		
		HotelService service = new HotelService();
		service.deleteMember(customer_id );		
		
		//
		request.getRequestDispatcher("WEB-INF/views/updateok.jsp").forward(request, response);
		
	}
}
