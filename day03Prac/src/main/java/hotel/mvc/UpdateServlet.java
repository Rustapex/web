package hotel.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update")
public class UpdateServlet   extends HttpServlet{

	/*
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String  method  =req.getMethod();
		
		if( method.equals("get")) {
			doGet(req, resp);
		}else  if( method.equals("post")){
			doPost(req, resp);
		}
	}
	
	*/
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 				
		
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
		String customer_id  =request.getParameter("customer_id");
		String name = request.getParameter("name");
		String tel=  request.getParameter("tel");
				
		System.out.println(name);
		System.out.println( tel);
		
		HotelService service = new HotelService();
		service.modifyMember(customer_id, name, tel);		
		
		//
		request.getRequestDispatcher("WEB-INF/views/updateok.jsp").forward(request, response);
		
	}
	
}
