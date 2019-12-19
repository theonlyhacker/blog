package liu.com.Dao;

import liu.com.Entity.Article;
import liu.com.Entity.ArticleType;
import liu.com.Entity.Reviews;

import java.util.List;

public interface articleDaoApi {
    //    添加文章
    Article addArticle(Article article);

    //  添加文章类型
    boolean addType(ArticleType articleType);

    //    查找文章类型
    List<ArticleType> findTypeList(String userId);

    //    删除文章类型
    int delArticleType(String typeId);

    //    删除文章
    int delArticle(String id);

    //    查找文章信息
    Article findBy(String id);

    //    查找文章一级评论
    List<Reviews> findReviewList(String id);

    //查找文章二级至多级评论
    List<Reviews> findReviewOnly(String id);

    //    添加评论
    Reviews addReview(Reviews reviews);

    //    查找文章目录信息
    List ArticleCatalog(String IdAuthor);

    //    查找所有文章目录信息
    List AllArticleCatalogs();

    //    根据关键词查找文章
    List allArticlesByKey(String key);

    //    更新文章信息
    int updateArticle(Article article);
}
