package Member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import page.PagingHandler;


@WebServlet("/listpage")
public class MemberListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int currentPage = 1;
		if(req.getParameter("p") != null) {
			currentPage = Integer.parseInt(req.getParameter("p"));
		}
		
		
		
//		[1] [2] [3] => 1그룹
//		정하는 것 
		int pageSize = 2;
		int grpSize = 3;
		
//		model (페이징 조회 결과 / 페이징 정보)
		
		MemberService service = new MemberService();
		ArrayList<Member> list = service.getMemberPaging(currentPage, pageSize);
		int totRecords = service.getTotalCnt();
		
//		페이징 정보
		
		PagingHandler handler = new PagingHandler(pageSize, grpSize, totRecords, currentPage);
		
		req.setAttribute("list", list);		// 4 줄 데이터 출력하기
		req.setAttribute("handler", handler);  // 하단 [1] [2] [3] [4]
		
//		view로 포워드
		req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
		
		
	}

}
