package liu.com.Servlet.userCenter;

import liu.com.Service.articleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delArticleServlet", urlPatterns = "/delArticleServlet")
public class delArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String typeId = request.getParameter("typeId");
        articleService articleService = new articleService();
//        这里我将删除文章和删除文章类型都放在一起写了，看看行不，
        if (null != id && articleService.delArticle(id) > 0) {
            request.getRequestDispatcher("ArticleCatalogServlet").forward(request, response);
        }

        if (null != typeId && articleService.delArticleType(typeId) > 0) {
            request.getRequestDispatcher("ArticleTypeServlet").forward(request, response);
        }
    }
}
