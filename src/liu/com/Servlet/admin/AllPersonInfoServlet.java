package liu.com.Servlet.admin;

import liu.com.Entity.User;
import liu.com.Service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllPersonInfoServlet", urlPatterns = "/AllPersonInfoServlet")
public class AllPersonInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService userService = new userService();
        List<User> list = userService.findAllUsers();
        if (list.size() > 0) {
            request.setAttribute("allUsers", list);
            request.getRequestDispatcher("admin/AllPersonCatalog.jsp").forward(request, response);
        }
    }
}
