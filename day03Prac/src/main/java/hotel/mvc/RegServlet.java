package hotel.mvc;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class RegServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/regForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자로부터 전송된 데이터에 대한 인코딩
		//한글
		req.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
				
		// 사용자 정보 가져오기
		String customer_id  =req.getParameter("customer_id");
		String name= req.getParameter("name");
		String tel= req.getParameter("tel");	
				
		HotelCustomer hc = new HotelCustomer( customer_id, name, tel);
		HotelService  service = new HotelService();
		service.registerMember(hc);
				
		//request.getRequestDispatcher("WEB-INF/views/ok.jsp").forward(request, response);	
				
		resp.sendRedirect(req.getContextPath() + "/hotelCustomerlist");   // 다른 서비스를  호출하게 해줌  ( 자동으로 브라우저에게  재요청을 지정함)
	}

}
