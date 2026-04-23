package day07Prac.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet{
	

	//
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		로그인 되어 있는 지 확인하기
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			String id = (String) session.getAttribute("id");

			if(id != null) {
//				session 이 null이 아니고 -> ID가 일치하면 주문정보 view 응답
				req.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(req, resp);
				return;
			}
		}
// 		로그인 재요청
		resp.sendRedirect(req.getContextPath() + "/login");
		
		
	}
}
