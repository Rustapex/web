package day01Prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dan")
public class Dan extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String dan = req.getParameter("num");
		
		int intDan = Integer.parseInt(dan);
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");                  
		out.println("<head>");       
		out.println("</head>"); 
		out.println("<body>");
		
		for(int i=1; i<10; i++) {
			
			out.println(intDan);
			out.println(" x ");
			out.println(i);
			out.println(" = ");
			out.println(intDan*i);
			out.println("<br>");
			
		}
		out.println("</body>"); 
		out.println("</html>"); 
	}

}
