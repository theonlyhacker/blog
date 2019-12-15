package liu.com.Servlet.userIndex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "peopleIndexServlet", urlPatterns = "/main")
public class peopleIndexServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
////
//        String username = request.getParameter("name");
//        request.setAttribute("name", username);
//        request.getRequestDispatcher("/peopleindex.jsp").forward(request, response);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("user/userIndex/peopleIndex.jsp").forward(request, response);
    }
}
