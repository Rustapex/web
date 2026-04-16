package day01Prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fighting")
public class Q7 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] messages = new String[] {
			"모든 사람은 천재성을 갖고 태어나지만, 대부분의 사람은 그것을 단지 몇분간만 유지한다.",
			"자신의 본성이 어떤 것이든 그에 충실 하라. 자신이 가진 재능의 끈을 놓아버리지 마라. 본성이 이끄는 대로 따르면 성공할 것이다",
			"사람을 존경하라, 그러면 그는 더 많은 일을 해 낼 것이다."
		};
		Random r1 = new Random();
		
		int index = r1.nextInt(messages.length);
		
		
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");                  
		out.println("<head>");       
		out.println("</head>"); 
		out.println("<body>");
		
		out.println(messages[index]);
		
		out.println("</body>"); 
		out.println("</html>"); 
	
	}


}
