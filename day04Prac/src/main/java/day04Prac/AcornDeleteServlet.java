package day04Prac;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class AcornDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        AcornService service = new AcornService();
        service.removeMember(id);

        // 삭제 후 목록 다시 조회해서 forward
        ArrayList<Acorn> list = service.getMembers();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/views/acornView.jsp").forward(req, resp);
    }
}