package acorn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// get, post => 오류가 발생하면 모두 처리할 수 있도록 service 메서드 활용
@WebServlet("/errorHandle3")
public class ErrorHandler3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/err3.jsp").forward(req, resp);
	}
}
