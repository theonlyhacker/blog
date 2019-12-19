package liu.com.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = "/AllArticleCatalogsServlet")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        游客访问的页面过滤，主要用这块实现
//
/*        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        String url = request.getServletPath();
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");

        if (userName == null || userName.equals("")){
            String youke = "游客";
            response.sendRedirect("login");
            return;
        }*/
//      功能暂时不用监听器实现，2019.12.13
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
