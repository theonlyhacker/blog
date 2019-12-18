package liu.com.Servlet.article.articleWrite;

import liu.com.Entity.Article;
import liu.com.Entity.ArticleType;
import liu.com.Service.articleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "addArticleServlet", urlPatterns = "/addArticleServlet")
public class addArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//
        String userId = (String) request.getSession().getAttribute("userId");
        String title = request.getParameter("title");
        String type = request.getParameter("articleType");
        String content = request.getParameter("content");
//
        Article article = new Article();
        article.setIdAuthor(userId);
        article.setTitle(title);
        article.setType(type);
        article.setContent(content);
//
        articleService articleService = new articleService();
        if (articleService.addArticle(article) != null)
            request.getRequestDispatcher("user/userIndex/peopleIndex.jsp").forward(request, response);
        else
            request.getRequestDispatcher("Article/addArticle.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = (String) request.getSession().getAttribute("userId");
        articleService articleService = new articleService();
        List<ArticleType> list = articleService.findTypeList(userId);
        if(list.size()>=0){
            request.setAttribute("ArticleType",list);
            request.getRequestDispatcher("Article/addArticle.jsp").forward(request, response);
        }

    }
}
