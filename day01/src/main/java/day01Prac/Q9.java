package day01Prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cute/img")
public class Q9 extends HttpServlet{
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter  out  =resp.getWriter();

		out.println("<html>");
		out.println("<head>");				// /프로젝트명/a.jpg
		out.println("</head>");           //   \프로젝트명/imgs/파일명.jpg          
		out.println("<body>");
		out.println("<img  src=\"https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20260408_165%2F1775651362088IYxVv_JPEG%2F3472568855110735957_20240613175253069.jpeg\" >");    
				 //  절대 경로(위치) , 프로젝트 기준으로 경로 표시 
		//  상대 경로(위치) , 
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
