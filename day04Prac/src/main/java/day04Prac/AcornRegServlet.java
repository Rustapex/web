package day04Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class AcornRegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/regForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String name = req.getParameter("name");
        String point_ = req.getParameter("point");

        int point = Integer.parseInt(point_);

        Acorn acorn = new Acorn();
        acorn.setId(id);
        acorn.setPw(pw);
        acorn.setName(name);
        acorn.setPoint(point);

        AcornService service = new AcornService();
        service.registerMember(acorn);

        // 등록 후 mainServlet(목록 서블릿)으로 redirect
        resp.sendRedirect(req.getContextPath() + "/acorn");
    }
}