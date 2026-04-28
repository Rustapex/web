package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice/list")
public class NoticeServlet  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		NoticeService service = new NoticeService();
		
		ArrayList<Notice> noticeList = service.getNoticeList();
		
		req.setAttribute("noticeList", noticeList);
		req.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp").forward(req, resp);
		
	}

}
