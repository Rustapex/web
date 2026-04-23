package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//request.getSession()
//현재 요청과 연결된 HttpSession(세션)이 있으면 그 세션을 반환한다.
//세션이 없으면 새로운 세션을 만들어서 반환한다.
//즉, "세션이 없으면 생성해서라도 반드시 세션 객체를 얻는 방식"이다.

//request.getSession(false)
//현재 요청과 연결된 기존 세션이 있는지 확인만 한다.
//기존 세션이 있으면 그 세션을 반환한다.
//기존 세션이 없으면 새로 만들지 않고 null을 반환한다.
//즉, "세션을 새로 만들지 않고 존재 여부만 확인하는 방식"이다.

@WebServlet("/order")
public class Order  extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//1.세션 확인 하기    
		//세션이 없다면 로그인이 안된상태로 로그인 화면으로 이동하게 함   
		HttpSession session = request.getSession(false);	

		// getSession() : 세션이 있으면 그 세션 반환, 없으면 새 세션을 생성해서 반환
		// getSession(false) : 세션이 있는지만 확인, 있으면 반환 / 없으면 null 반환
		
		String id  = (String) session.getAttribute("id");
		
		
		//2.세션에 로그인정보가 있다면
		if( id != null) {		
			// 해당id의 주문정보 가져오기(dao사용)			
			//주문정보리스트 모델 심기
			request.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(request, response);			
		} //세션에 로그인정보가 없다면
		else {
			
			//로그인처리하는 서블릿 (서비스) 리다이랙트  
			response.sendRedirect("/sessionLogin/login");
		}
		
		
	}
}
