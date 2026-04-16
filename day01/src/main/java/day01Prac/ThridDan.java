package day01Prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dan3")
public class ThridDan extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		int dan = 3;
		
		out.println("<html>");                  
		out.println("<head>");       
		out.println("</head>"); 
		out.println("<body>");
		
		for(int i=1; i<10; i++) {
			
			out.println(dan);
			out.println(" x ");
			out.println(i);
			out.println(" = ");
			out.println(dan*i);
			out.println("<br>");
			
		}
		out.println("</body>"); 
		out.println("</html>"); 
	}

}
