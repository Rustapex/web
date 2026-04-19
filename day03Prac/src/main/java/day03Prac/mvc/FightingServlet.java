package day03Prac.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvcfighting")
public class FightingServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 사용자 입력 가져오기
		
		// model (화이팅 메시지)
//		String data = "행운은 언제나 당신 편입니다.";
		
		FightingService service = new FightingService();
		String data = service.getMessage();
		
		// 저장소 req(request)를 저장소로 사용함 (spring과 동일)
		// 요청(request) -> 응답될(response) 때 까지 살아있는 저장소
		// 저장, 꺼내오기
		
		req.setAttribute("data", data); 	// KEY , VALUE (KEY를 원하는 값으로 정한다)
		
		// 뷰 (화면 뷰)
		
		// 만들어둔 뷰로로 forward 하기
		
		req.getRequestDispatcher("/WEB-INF/views/fightingView.jsp").forward(req, resp);
		
		
	}

}
