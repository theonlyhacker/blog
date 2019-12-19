package liu.com.Servlet.article.articleShow;

import liu.com.Entity.Article;
import liu.com.Entity.Reviews;
import liu.com.Service.articleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "ArticleInfoServlet", urlPatterns = "/ArticleInfoServlet")
public class ArticleInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String reviewContent = request.getParameter("newReview");
        String articleId = request.getParameter("articleId");
        String userId = (String) request.getSession().getAttribute("userId");
//        提取authorId是因为作者本人对文章添加评论后和看客添加评论后返回的页面应该是不一样的
        String authorId = request.getParameter("authorId");
        String reviewTargetId = request.getParameter("ReviewTargetId");
//        reviewTargetId暂时没写，有后端直接传null值进去先测试2019.12.1
//
        Reviews reviews = new Reviews();
        reviews.setReviewUserId(userId);
        reviews.setArticleId(articleId);
        reviews.setReviewContent(reviewContent);
        reviews.setReviewTargetId(reviewTargetId);

        articleService articleService = new articleService();
        if (articleService.addReview(reviews) != null) {
            if (userId.equals(authorId)) {
                response.sendRedirect("ArticleCatalogServlet");
            } else {
                response.sendRedirect("AllArticleCatalogsServlet");
            }
        }
    }

    //    不用list的原因主要是出现重复，怎么去重都各种重复重复，还是set真香
    Set<Reviews> set = new HashSet<Reviews>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//              取得文章id
        String id = request.getParameter("id");
//              取得当前用户id
        String userId = (String) request.getSession().getAttribute("userId");
//        取得访问文章的用户的status
        String sta = request.getParameter("status");
        if (sta.equals("youke")) {
            userId = "youke";
        }
//
        articleService articleService = new articleService();
//
        Article article = articleService.findById(id);
//
        List<Reviews> reviewsList = articleService.findReviewList(id);
        set.clear();
        for (int i = 0; i < reviewsList.size(); i++) {
            set.addAll(articleService.findReviewOnly(reviewsList.get(i).getReviewId()));
        }
//
        if (article != null) {
            request.setAttribute("article", article);
            request.setAttribute("reviewsList", reviewsList);
            request.setAttribute("commentsList", set);
            request.setAttribute("userIdd", userId);
            request.getRequestDispatcher("Article/ArticleInfo.jsp").forward(request, response);
        }
     /*   thisSet.clear();//在请求进来的时候讲set集合清空
        for(Reviews reviews:reviewsList){
            Set<Reviews> sets = findReviewOther(reviews.getReviewId());
            JsonConfig jsonConfig = new JsonConfig();
//        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
            JSONArray array = JSONArray.fromObject(sets, jsonConfig);
            JSONObject json = new JSONObject();
            json.put(0, array);
            response.getWriter().write(json.toString());
        }*/

    }

    //暂时先不写这个 json不会。太多看不懂了
/*    public void findReonly(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String commentid = request.getParameter("commentid");
        List<Reviews> sets = findReviewOther(commentid);
        //调用递归方法
        JsonConfig jsonConfig = new JsonConfig();
//        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        JSONArray array = JSONArray.fromObject(sets, jsonConfig);
        JSONObject json = new JSONObject();
        json.put(0, array);
        response.getWriter().write(json.toString());
        //返回json格式的数据

    }*/
//先不考虑第三层第四层的回复，就是第二次回复，直接先暂时不用该函数
    /*public void findReviewOther(String uid) {
        articleService articleService = new articleService();
        List<Reviews> list = articleService.findReviewOnly(uid);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                set.add(list.get(i));
//                String id = list.get(i).getReviewId();
//                findReviewOther(id);
            }
        }
//        return thisList;
    }*/
}
