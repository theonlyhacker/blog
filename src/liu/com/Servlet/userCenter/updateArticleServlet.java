package liu.com.Servlet.userCenter;

import liu.com.Entity.Article;
import liu.com.Service.articleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateArticleServlet", urlPatterns = "/updateArticleServlet")
public class updateArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String type = request.getParameter("articleType");
        String content = request.getParameter("content");
//
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setType(type);
        article.setContent(content);
//
        articleService articleService = new articleService();
        if (articleService.updateArticle(article) > 0) {
            request.getRequestDispatcher("user/userIndex/peopleIndex.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
//
        String userId = (String) request.getSession().getAttribute("userId");
//
        articleService articleService = new articleService();
//
        if (articleService.findById(id) != null) {
            request.setAttribute("article", articleService.findById(id));
            request.setAttribute("ArticleType", articleService.findTypeList(userId));
            request.getRequestDispatcher("Article/updateArticle.jsp").forward(request, response);
        }
    }
}
