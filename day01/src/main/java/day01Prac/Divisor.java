package day01Prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/divisor")
public class Divisor extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num1 = req.getParameter("num1");
		
		int intNum1 = Integer.parseInt(num1);
		ArrayList<Integer> divisor = new ArrayList<Integer>();
		
		for(int i=1; i<=intNum1; i++) {
			if(intNum1 % i ==0) {
				divisor.add(i);
			}
		}
		
		
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");                  
		out.println("<head>");       
		out.println("</head>"); 
		out.println("<body>");
		out.println(intNum1);
		out.println("의 약수");
		out.println("<br>");

		for(int div1 : divisor) {
			out.println(div1);
		}
	
		out.println("</body>"); 
		out.println("</html>"); 
		out.close();
	}
}
