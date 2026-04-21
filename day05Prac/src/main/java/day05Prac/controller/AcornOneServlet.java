package day05Prac.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day05Prac.dto.Acorn;
import day05Prac.service.AcornService;

@WebServlet("/acorn/detail")
public class AcornOneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println("넘어온 id = " + id);
		
		AcornService service = new AcornService();
		Acorn acorn = service.getAcorn(id);
		System.out.println("조회된 acorn = " + acorn);
		
		req.setAttribute("acorn", acorn);
		
		req.getRequestDispatcher("/WEB-INF/views/acorn/detail.jsp").forward(req, resp);
	}
}
