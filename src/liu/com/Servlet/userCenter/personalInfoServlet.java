package liu.com.Servlet.userCenter;

import com.google.gson.Gson;
import liu.com.Entity.User;
import liu.com.Service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "personalInfoServlet", urlPatterns = "/personalInfoServlet")
public class personalInfoServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
////
//        request.getRequestDispatcher("/peopleindex.jsp").forward(request, response);
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=UTF-8");
        HttpSession hs = request.getSession();
        String userId = (String) hs.getAttribute("userId");
//        来自其他用户eg评论里查看用户信息
        String userId2 = request.getParameter("userId");
        if (userId2 != null) {
            userId = userId2;
            request.setAttribute("status", "thevistor");
        }
        userService userservice = new userService();
        String Id = request.getParameter("Id");
        if (Id != null) {
            User user = userservice.getUserByUserName(Id);
            Gson gson = new Gson();
            String UserArray = gson.toJson(user, user.getClass());
//
            PrintWriter out = response.getWriter();
            out.write(UserArray);
            out.flush();
            out.close();
            return;
        }
//        为了区别访问该页面的人是用户本人还是其他人访问主页面，添加一个属性用来储存访问人的等级
//        2019.12.10这里添加一个弹窗，即外人查看别人信息是弹出一个窗口，就不用页面跳转了，用json封装属性传过去就行
//        暂时未做，先做评论功能2019.12.1
//        String uesrid = request.getParameter("userId");
// 2019.12.6,已完成这个功能，直接传入一个属性，利用status是否为空来判断是谁查看用户信息

//

        User user = userservice.getUserByUserName(userId);
//
        request.setAttribute("user", user);
        request.getRequestDispatcher("user/userCenter/personalInfo.jsp").forward(request, response);
    }

}
