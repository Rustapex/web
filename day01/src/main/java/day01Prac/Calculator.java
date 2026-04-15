package day01Prac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calculator extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");

		
		int intNum1 = Integer.parseInt(num1);
		int intNum2 = Integer.parseInt(num2);

		int plusNum = intNum1 + intNum2;
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");                  
		out.println("<head>");       
		out.println("</head>"); 
		out.println("<body>");
		out.println(intNum1);
		out.println(" + ");
		out.println(intNum2);
		out.println(" = ");
		out.println(plusNum);
		out.println("</body>"); 
		out.println("</html>"); 
	}
		

}
