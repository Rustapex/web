package day01Prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cute/img/random")
public class Q10 extends HttpServlet{
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] urls = new String[] {
			"/day01/imgs/first.jpg",
			"/day01/imgs/second.jpg",
			"/day01/imgs/meat.jpg"
		};
		
		Random randomNum = new Random();
		int index = randomNum.nextInt(urls.length);
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter  out  =resp.getWriter();

		out.println("<html>");
		out.println("<head>");				// /프로젝트명/a.jpg
		out.println("</head>");           //   \프로젝트명/imgs/파일명.jpg          
		out.println("<body>");
		out.println("<img  src='" + urls[index] + "'>");    
				 
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

}
