package day05Prac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day05Prac.dto.Acorn;
import day05Prac.service.AcornService;

@WebServlet("/acorn/update")
public class AcornUpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		AcornService service = new AcornService();
		Acorn acorn = service.getAcorn(id);
		
		req.setAttribute("acorn", acorn);
		req.getRequestDispatcher("/WEB-INF/views/acorn/updateForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		int point = Integer.parseInt(req.getParameter("point"));
		
		Acorn acorn = new Acorn();
		acorn.setId(id);
		acorn.setPw(pw);
		acorn.setPoint(point);
		
		AcornService service = new AcornService();
		service.modifyAcorn(acorn);
		
//		resp.sendRedirect("/day05Prac/acorn/list");
		resp.sendRedirect(req.getContextPath() + "/acorn/list");
		
		
	}
}
