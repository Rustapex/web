package day07Prac.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		boolean result = false;
		
		if(id.equals(pw)) {
			result = true;
		}
		
//		login 성공하면 성공 정ㅈ보를 세션에 저장하기
		if(result == true) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			
//			main page 재 요청
			resp.sendRedirect(req.getContextPath() + "/home");
		}
		
	}
}
