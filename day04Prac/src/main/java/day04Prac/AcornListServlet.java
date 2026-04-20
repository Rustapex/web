package day04Prac;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/acorn")
public class AcornListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 모델 가져오기
		AcornService service = new AcornService();
		ArrayList<Acorn> list = service.getMembers(); // acorn 학생 정보 => model
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/acornView.jsp").forward(req, resp);
		
	}
}
