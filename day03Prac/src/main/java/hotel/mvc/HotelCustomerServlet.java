package hotel.mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hotelCustomerlist")
public class HotelCustomerServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//데이타 만들기
		//Model => 서비스 , DAO
		HotelService  service  = new HotelService();
		//ArrayList<Acorn> list  =service.getMemberListTmp();
		ArrayList<HotelCustomer> list  =service.getMemberListReal();
//		System.out.println( list.get(0).getCustomer_id());
		
		//모델 심기(request 저장소 : 하나의 요청에서 응답될 때까지 유효한 저장소 이다) 
		request.setAttribute("list", list);		
		request.getRequestDispatcher("WEB-INF/views/list.jsp").forward(request, response);
		
		
		
	}

}
