package liu.com.Servlet.admin;

import liu.com.Service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "prohibitPersonServlet",urlPatterns = "/prohibitPersonServlet")
public class prohibitPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        String id = request.getParameter("id");
        userService service = new userService();
        if(service.prohibitPerson(id,status)>0){

            request.getRequestDispatcher("AllPersonInfoServlet").forward(request,response);
        }
    }
}
