package liu.com.Service;

import liu.com.Dao.articleDao;
import liu.com.Entity.Article;
import liu.com.Entity.ArticleType;
import liu.com.Entity.Reviews;

import java.util.List;

public class articleService {
    //    添加文章
    public Article addArticle(Article article) {
        articleDao articleDao = new articleDao();
        Article article1 = articleDao.addArticle(article);
        return article1;
    }

    //  添加文章类型
    public boolean addType(ArticleType articleType) {
        boolean success;
        articleDao articleDao = new articleDao();
        success = articleDao.addType(articleType);
        return success;
    }

    //  删除文章类型
    public int delArticleType(String typeId) {
        articleDao a = new articleDao();
        int ret = a.delArticleType(typeId);
        return ret;
    }

    //    查找用户的所有文章类型
    public List<ArticleType> findTypeList(String userId) {
        articleDao articleDao = new articleDao();
        List<ArticleType> list = articleDao.findTypeList(userId);
        return list;
    }

    //删除文章
    public int delArticle(String id) {
        articleDao articleDao = new articleDao();
        int ret = articleDao.delArticle(id);
        return ret;
    }

    //   查找文章信息
    public Article findById(String id) {
        articleDao articleDao = new articleDao();
        Article newArticle = articleDao.findBy(id);
        return newArticle;
    }

    //    根据文章id查找评论信息
    public List<Reviews> findReviewList(String id) {
        articleDao articleDao = new articleDao();
        List<Reviews> list = articleDao.findReviewList(id);
        return list;
    }

    //    查找剩余评论
    public List<Reviews> findReviewOnly(String id) {
        articleDao articleDao = new articleDao();
        List<Reviews> list = articleDao.findReviewOnly(id);
        return list;
    }

    //    添加评论
    public Reviews addReview(Reviews reviews) {
        articleDao articleDao = new articleDao();
        Reviews reviews1 = articleDao.addReview(reviews);
        return reviews1;
    }

    //  输出文章目录信息
    public List Catalogs(String IdAuthor) {
        articleDao articleDao = new articleDao();
        List catalogs = articleDao.ArticleCatalog(IdAuthor);
        return catalogs;
    }

    //    输出所有文章目录信息
    public List findAllCatalogs() {
        articleDao articleDao = new articleDao();
        List allArticleCatalogs = articleDao.AllArticleCatalogs();
        return allArticleCatalogs;
    }

    //    根据题目关键词查找文章信息
    public List allArticleByKey(String key) {
        articleDao articleDao = new articleDao();
        List articlesList = articleDao.allArticlesByKey(key);
        return articlesList;
    }

    //    更新文章信息
    public int updateArticle(Article article) {
        articleDao articleDao = new articleDao();
        int article1 = articleDao.updateArticle(article);
        return article1;
    }
}
