package day09Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
/*		1. try~ catch
 		2. 에러 코드, exception -type 예외 page가 응답되게 하기 - web.xml
*/
		String str = req.getParameter("str");
		HelloService service = new HelloService();
		
		int cnt = 0;
		try {
			// 정상
			cnt = service.getLength(str);	
			
			req.setAttribute("cnt", cnt);
			req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp);
			
		} catch (Exception e) {
			// 문제 발생
			e.printStackTrace();				
			req.getRequestDispatcher("/WEB-INF/views/helloErr.jsp").forward(req, resp);
		}
		
		
		
/*	
		정상적인 응답뷰
		error가 발생하는 경우 errorView
*/
	}
}
