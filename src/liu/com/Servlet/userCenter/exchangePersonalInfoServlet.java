package liu.com.Servlet.userCenter;

import liu.com.Entity.User;
import liu.com.Service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "exchangePersonalInfoServlet", urlPatterns = "/exchangePersonalInfoServlet")
public class exchangePersonalInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取更新之后的用户信息(默认是userName不做修改)
//        String userName = request.getParameter("userName");
//        2019/11/16 必须要这个utf-8的格式，不然前面jsp页面传过来的中文乱码
        request.setCharacterEncoding("utf-8");
//        这里先补酒一下，用户自己修改信息从session里取userName,而管理员是直接传一个userName过来,
//        看了下用户自己修改信息的jsp页面，我没搞懂我以前为啥userName不直接从form里取？
        String userName = request.getParameter("userName");
        if (userName.equals("")) {
            userName = (String) request.getSession().getAttribute("userName");
        }
        String sex = request.getParameter("sex");
        String userTel = request.getParameter("userTel");
        String password = request.getParameter("Password");
        String status = request.getParameter("status");
//当用户自己修改信息的时候，没有状态的修改
        String status1 = "";
        if (status == null) {
            status = "normal";
            status1 = "1";
        }
//
        User user = new User();
        user.setUsername(userName);
        user.setSex(sex);
        user.setTel(userTel);
        user.setPassword(password);
        user.setStatus(status);
//
        userService userService = new userService();

        User newuser = userService.update(user);
        if (status1.equals("")) {
//            request.getRequestDispatcher("admin/AllPersonCatalog.jsp").forward(request,response);
            response.sendRedirect("AllPersonInfoServlet");
            return;
        }
//        还是不能满足及时插入，待解决，即这行代码会延迟执行。已解决，原来是dao层代码写错了，在finally里直接返回null了
        if (newuser != null) {
            request.setAttribute("user", newuser);
            request.getRequestDispatcher("user/userIndex/peopleIndex.jsp").forward(request, response);
        } else {
            request.setAttribute("user", user);
            request.getRequestDispatcher("loginRegister/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        HttpSession hs = request.getSession();
        String userName = (String) hs.getAttribute("userName");
        userService userservice = new userService();
        User user = userservice.getUserByUserName(userName);
//
        request.setAttribute("user", user);
        request.getRequestDispatcher("user/userCenter/exchangePersonalInfo.jsp").forward(request, response);
    }
}
