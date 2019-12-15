package liu.com.Servlet.loginRegister;

import liu.com.Entity.User;
import liu.com.Service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", urlPatterns = "/register")
public class registerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("loginRegister/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//获取注册用户信息
        String userName = request.getParameter("userName");
        String sex = request.getParameter("sex");
        String userTel = request.getParameter("userTel");
        String password = request.getParameter("Password");
        String status = request.getParameter("status");
//       普通用户自己添加就没有status属性的传入
        if(status.equals(null)){
            status = "normal";
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
        User newuser = userService.adduser(user);
        if(user.getStatus().equals("admin")){
            response.sendRedirect("main");
            return;
        }
//2019/11/24 由于id是在dao层加入，因此在这一步是查不到id的，因此逻辑就判断newuser为空//已解决，dao层代码写错了
        if (user.getUsername() != null) {
/*//            由于有管理员添加，因此只有当用户注册成功的时候才往session里重新添加userName
先直接注释掉试试，不添加
            HttpSession hs = request.getSession();
            hs.setAttribute("username", userName);*/

            request.setAttribute("user", newuser);
//            response.sendRedirect("main");重定向的方法
            request.getRequestDispatcher("loginRegister/registerSuccess.jsp").forward(request, response);//z转url的方法
        } else {
            request.setAttribute("user", user);
            request.getRequestDispatcher("loginRegister/register.jsp").forward(request, response);
//            response.sendRedirect("");
        }


    }


}
