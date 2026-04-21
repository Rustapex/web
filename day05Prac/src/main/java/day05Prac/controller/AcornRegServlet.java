package day05Prac.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day05Prac.dto.Acorn;
import day05Prac.service.AcornService;

@WebServlet("/acorn/reg")
public class AcornRegServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/acorn/reg.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		int point = Integer.parseInt(req.getParameter("point"));
		String strBirth = req.getParameter("birth");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date birth = null;
		try {
			birth = df.parse(strBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Acorn acorn = new Acorn();
		acorn.setId(id);
		acorn.setPw(pw);
		acorn.setName(name);
		acorn.setPoint(point);
		acorn.setBirth(birth);
		
		AcornService service = new AcornService();
		int result = service.registerMember(acorn);
		
		req.setAttribute("result", result);
//		req.getRequestDispatcher("/WEB-INF/views/acorn/reg.jsp").forward(req, resp); ok.jsp 특정 뷰 반환
		
		resp.sendRedirect(req.getContextPath() + "/home");
//		resp.sendRedirect("/day05Prac/home");

//		redirect , 재사용 서버 (재 요청 코드302) -> 브라우저 자동으로 재요청, 메인 페이지 요청하기
	}
}
