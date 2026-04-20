package day04Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1차시 3번 문제 mvc pattern
// dao -> service -> servlet -> view (개발 순서)
// servlet -> view -> model (service, dao)
// DTO - 구조화된 데이터 담아서 다른 계층으로 보낼 때 사용 (User, Customer, Book .. etc)

@WebServlet("/ex03")
public class Ex03Servlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		학생성적 데이터(model)
		Ex03Service service = new Ex03Service();
		Score score = service.getScore();
		
//		controller , view 와 함께 사용할 수 있는 저장소 request (요청 -> 응답되기까지 사용할 수 있는 저장소)
		req.setAttribute("data", score);
		req.getRequestDispatcher("/WEB-INF/views/ex03View.jsp").forward(req, resp);
	}
	

}
