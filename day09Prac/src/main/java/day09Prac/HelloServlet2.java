package day09Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello2")
public class HelloServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		예외처리 하지 않고 설정파일에서 에러코드나 예외처리 클래스 타입으로 처리하기
		
		String str = (String) req.getParameter("str");
		HelloService2 service = new HelloService2();
		
		int cnt = service.getLength(str);
		
		req.setAttribute("cnt", cnt);
		
		req.getRequestDispatcher("/WEB-INF/views/hello2.jsp").forward(req, resp);
	}
}
