package liu.com.Servlet.loginRegister;


import liu.com.Entity.User;
import liu.com.Service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = "/login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

//      将错误的用户名带回来
        User user = new User();
        user.setUsername(userName);
//
        String errorMsg;
//
        userService userservice = new userService();

        if (userservice.getUserByUserName(userName).getPassword().equals(password)) {
            String status = userservice.getUserByUserName(userName).getStatus();
            HttpSession hs = request.getSession();
            if (!status.equals("disable")) {
                //            userservice.login(userName, password)
                //没有用request进行转向,想的是转到主页面就改下url
                //request.getRequestDispatcher("/peopleIndexServlet").forward(request,response);
                //        在一個session會話里储存名字

                hs.setAttribute("userName", userName);
                String id = userservice.getUserByUserName(userName).getUserid();
                hs.setAttribute("userId", id);
//
                hs.setAttribute("status", status);

//
                response.sendRedirect("main");
            } else {
                errorMsg = "该账号已被封禁，请联系网站管理员";
                request.setAttribute("user", user);
                request.setAttribute("errorMsg", errorMsg);
                request.getRequestDispatcher("loginRegister/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("user", user);
            errorMsg = "用户名或者密码错误,请重新输入!";
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("loginRegister/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("loginRegister/login.jsp").forward(request, response);
    }
}
