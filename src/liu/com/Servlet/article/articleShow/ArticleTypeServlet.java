package liu.com.Servlet.article.articleShow;

import liu.com.Entity.ArticleType;
import liu.com.Service.articleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ArticleTypeServlet", urlPatterns = "/ArticleTypeServlet")
public class ArticleTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String userId = (String) request.getSession().getAttribute("userId");

        ArticleType articleType = new ArticleType();
        articleType.setUserId(userId);
        articleType.setTypeContent(type);

        articleService articleService = new articleService();
//
        if (articleService.addType(articleType)) {
            request.getRequestDispatcher("user/userIndex/peopleIndex.jsp").forward(request, response);
        } else
            request.getRequestDispatcher("user/userIndex/peopleIndex.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("userId");
        articleService articleService = new articleService();
        List<ArticleType> list = new ArrayList<>();
        list = articleService.findTypeList(id);
        if (list.size() >= 0) {
            request.setAttribute("ArticleType", list);
            request.getRequestDispatcher("Article/ArticleType.jsp").forward(request, response);
        }
    }
}
