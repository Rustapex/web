package prac02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dan")
public class Q3 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String dan = req.getParameter("dan");
		int intDan = Integer.parseInt(dan);
		
		Q3Dan d1 = new Q3Dan();
		
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");                  
		out.println("<head>");       
		out.println("</head>"); 
		out.println("<body>");
		for(String dans : d1.dan(intDan)) {
			out.println(dans);
			out.println("<br>");
		}
								
		out.println("</body>"); 
		out.println("</html>"); 
		
		out.close();
		
	}
}
