package day04Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 하나의 서블릿은 하나의 요청을 처리한다. get, post를 나눠서 처리한다.

// serelvet -> service override 해 처리하였음 (처음에)
// servlet -> service(요청 방법을 어덩와서 get, post인지 알수 있음) -> doGet, doPost 호출 

@WebServlet("/lotte.do")
public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("get");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("post");
	}

}
