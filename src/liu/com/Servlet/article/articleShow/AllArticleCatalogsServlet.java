package liu.com.Servlet.article.articleShow;

import liu.com.Service.articleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllArticleCatalogsServlet",urlPatterns = "/AllArticleCatalogsServlet")
public class AllArticleCatalogsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String status = request.getParameter("status");
        if(status.equals("youke")){
            request.setAttribute("status",status);
        }
        String key = request.getParameter("searchArticle");

        articleService articleService = new articleService();
        List list = articleService.allArticleByKey(key);
        if (list != null) {
            request.setAttribute("list",list);
            request.getRequestDispatcher("Article/AllArticleCatalogs.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        if(status.equals("youke")){
            request.setAttribute("status",status);
        }
        articleService articleService = new articleService();
        List list = articleService.findAllCatalogs();
        if (list != null) {
            request.setAttribute("list",list);
            request.getRequestDispatcher("Article/AllArticleCatalogs.jsp").forward(request, response);
        }
    }
}
