package prac02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc/java")
public class Q1 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		Q1calc res = new Q1calc();

		
		int intNum1 = Integer.parseInt(num1);
		int intNum2 = Integer.parseInt(num2);

		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");                  
		out.println("<head>");       
		out.println("</head>"); 
		out.println("<body>");
		
		out.println("덧셈");
		out.println(res.plu(intNum1, intNum2));
		
		out.println("<br>뺄셈");
		out.println(res.min(intNum1, intNum2));
		
		out.println("<br>곱셈");
		out.println(res.pro(intNum1, intNum2));
		
		out.println("<br>나눗셈");
		out.println(res.div(intNum1, intNum2));
		
		out.println("</body>"); 
		out.println("</html>"); 
		
		out.close();
	}
}



