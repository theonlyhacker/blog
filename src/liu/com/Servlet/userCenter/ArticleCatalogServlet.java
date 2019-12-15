package liu.com.Servlet.userCenter;

import liu.com.Service.articleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArticleCatalogServlet", urlPatterns = "/ArticleCatalogServlet")
public class ArticleCatalogServlet extends HttpServlet {
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * }
	 */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String IdAuthor = (String) request.getSession().getAttribute("userId");
        articleService articleService = new articleService();
        List list = articleService.Catalogs(IdAuthor);
        if (list != null) {
            request.setAttribute("list",list);
            request.getRequestDispatcher("Article/ArticleCatalog.jsp").forward(request, response);
        }

    }
}
