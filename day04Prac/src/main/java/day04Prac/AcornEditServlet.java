package day04Prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class AcornEditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        AcornService service = new AcornService();
        Acorn acorn = service.getMember(id);

        req.setAttribute("acorn", acorn);
        req.getRequestDispatcher("/WEB-INF/views/editForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        String point_ = req.getParameter("point");

        int point = Integer.parseInt(point_);

        Acorn acorn = new Acorn();
        acorn.setId(id);
        acorn.setPw(pw);
        acorn.setPoint(point);

        AcornService service = new AcornService();
        service.modifyMember(acorn);

        // 수정된 데이터 다시 조회해서 forward
        Acorn resultAcorn = service.getMember(id);
        req.setAttribute("acorn", resultAcorn);
        req.getRequestDispatcher("/WEB-INF/views/acornDetail.jsp").forward(req, resp);
    }
}