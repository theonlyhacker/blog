package liu.com.Dao;

import liu.com.Entity.Article;
import liu.com.Entity.ArticleType;
import liu.com.Entity.Reviews;
import liu.com.common.dbObject;
import liu.com.common.generateID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class articleDao implements articleDaoApi {
    private dbObject db = new dbObject();
    private generateID id = new generateID();
    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public Article addArticle(Article article) {
        try {
            cn = db.open();

            String sql1 = "insert into blog.article(IdArticle, IdArticleAuthor, status, ArticleType, ArticleTitle, ArticleContent, ReleaseDate) values (?,?,?,?,?,?,?)";
//
            st = cn.prepareStatement(sql1);
//
//            给文章添加id属性
            article.setId(id.getUUid());
//          给文章添加生成时间
            article.setDatetime(id.date());
//
            st.setString(1, article.getId());
            st.setString(2, article.getIdAuthor());
            st.setString(3, "1");
            st.setString(4, article.getType());
            st.setString(5, article.getTitle());
            st.setString(6, article.getContent());
            st.setString(7, article.getDatetime());

//
            st.executeUpdate();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } finally {

        }
        return article;
    }

    @Override
    public boolean addType(ArticleType articleType) {
        boolean success = true;
        try {
            cn = db.open();

            String sql1 = "insert into blog.articletype(Idarticletype, userId, typeContent, registerDate) values (?,?,?,?)";
//
            st = cn.prepareStatement(sql1);
//
//            给文章添加id属性
            articleType.setId(id.getUUid());
//          给文章添加生成时间
            articleType.setRegisterDate(id.date());
//
            st.setString(1, articleType.getId());
            st.setString(2, articleType.getUserId());
            st.setString(3, articleType.getTypeContent());
            st.setString(4, articleType.getRegisterDate());
//
            success = st.execute();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } finally {
        }
        return success;
    }

    @Override
    public List<ArticleType> findTypeList(String userId) {
        List<ArticleType> typeList = new ArrayList();
        try {
            cn = db.open();
            String sql = "select * from articletype where userId = ?";
            st = cn.prepareStatement(sql);
            st.setString(1,userId);
            rs = st.executeQuery();
//
            while (rs.next()){
                String typeId = rs.getString("idarticletype");
                String idUser = rs.getString("userId");
                String typeContent = rs.getString("typeContent");
                String date = rs.getString("registerDate");
//
                ArticleType articleType = new ArticleType();
//
                articleType.setId(typeId);
                articleType.setUserId(idUser);
                articleType.setTypeContent(typeContent);
                articleType.setRegisterDate(date);
//
                typeList.add(articleType);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
        }
        return typeList;
    }

    @Override
    public int delArticleType(String typeId) {
        int ret = 0;
        try {
            cn = db.open();

            String sql = "delete from articletype where idarticletype=?;";

            st = cn.prepareStatement(sql);

            st.setString(1, typeId);

            ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return ret;
    }

    @Override
    public int delArticle(String id) {
        int ret = 0;
        try {
            cn = db.open();

            String sql = "delete from article where IdArticle=?;";

            st = cn.prepareStatement(sql);

            st.setString(1, id);

            ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return ret;
    }

    @Override
    public Article findBy(String id) {
        Article article = new Article();
        try {
            cn = db.open();

            String sql1 = "select * from blog.article where IdArticle=?";

            st = cn.prepareStatement(sql1);

            st.setString(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                article.setId(id);
                article.setIdAuthor(rs.getString("IdArticleAuthor"));
                article.setStatus(rs.getString("status"));
                article.setType(rs.getString("ArticleType"));
                article.setTitle(rs.getString("ArticleTitle"));
                article.setContent(rs.getString("ArticleContent"));
                article.setDatetime(rs.getString("ReleaseDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return article;
    }

    @Override
    public List<Reviews> findReviewList(String id) {
        List<Reviews> reviewsList = new ArrayList();
        try {
            cn = db.open();

            String sql = "select r.*,u.usersName from review  r \n" +
                    "join users u on u.id_Users = r.ReviewUserId\n" +
                    "where r.ArticleId=? and r.ReviewTargetId='0'order by r.ReviewDate desc; ";

            st = cn.prepareStatement(sql);

            st.setString(1, id);

            rs = st.executeQuery();
            //            reviewsList = JdbcHelper.getResult(rs,reviewsList.getClass());
//
            while (rs.next()) {
                String ReviewId = rs.getString("ReviewId");
                String ArticleId = rs.getString("ArticleId");
                String ReviewTargetId = rs.getString("ReviewTargetId");
                String ReviewUserId = rs.getString("ReviewUserId");
                String ReviewContent = rs.getString("ReviewContent");
                String ReviewDate = rs.getString("ReviewDate");
                String ReviewName = rs.getString("usersName");
//
                Reviews reviews = new Reviews();
                reviews.setReviewId(ReviewId);
                reviews.setArticleId(ArticleId);
                reviews.setReviewTargetId(ReviewTargetId);
                reviews.setReviewUserId(ReviewUserId);
                reviews.setReviewContent(ReviewContent);
                reviews.setReviewDate(ReviewDate);
                reviews.setReviewName(ReviewName);
//
                reviewsList.add(reviews);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return reviewsList;
    }

    @Override
    public List<Reviews> findReviewOnly(String id) {
        List<Reviews> reviewsList = new ArrayList();
        try {
            cn = db.open();

            String sql = "select u2.usersName,u1.usersName Cname,r1.ReviewUserId Cuid,r2.*\n" +
                    "from review r1\n" +
                    "    join review r2 on r1.ReviewId = r2.ReviewTargetId\n" +
                    "    join users u1 on r1.ReviewUserId = u1.id_Users\n" +
                    "    join users u2 on r2.ReviewUserId = u2.id_Users\n" +
                    "where r1.ReviewId=? order by r2.ReviewDate desc ";

            st = cn.prepareStatement(sql);

            st.setString(1, id);

            rs = st.executeQuery();
            //            reviewsList = JdbcHelper.getResult(rs,reviewsList.getClass());
//
            while (rs.next()) {
//                评论人信息
                String ReviewName = rs.getString("usersName");
                String ReviewUserId = rs.getString("ReviewUserId");
//                被评论人信息储存姓名和id

//                该条评论的id
                String ReviewId = rs.getString("ReviewId");
//                被评论人信息
                String Cname = rs.getString("Cname");
                String Cuid = rs.getString("Cuid");

                String ArticleId = rs.getString("ArticleId");
                String ReviewTargetId = rs.getString("ReviewTargetId");

                String ReviewContent = rs.getString("ReviewContent");
                String ReviewDate = rs.getString("ReviewDate");

//
                Reviews reviews = new Reviews();
//
                reviews.setReviewName(ReviewName);
                reviews.setReviewUserId(ReviewUserId);

                reviews.setReviewId(ReviewId);
                reviews.setReviewCName(Cname);
                reviews.setReviewCUserId(Cuid);

                reviews.setArticleId(ArticleId);
                reviews.setReviewTargetId(ReviewTargetId);

                reviews.setReviewContent(ReviewContent);
                reviews.setReviewDate(ReviewDate);

//
                reviewsList.add(reviews);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return reviewsList;
    }

    @Override
    public Reviews addReview(Reviews reviews) {
        try {
            cn = db.open();

            String sql = "insert into blog.review(ReviewId, ArticleId, ReviewTargetId, ReviewUserId, ReviewContent, ReviewDate) values (?,?,?,?,?,?)";

            st = cn.prepareStatement(sql);

            reviews.setReviewId(id.getUUid());
            reviews.setReviewDate(id.date());

            st.setString(1, reviews.getReviewId());
            st.setString(2, reviews.getArticleId());
            st.setString(3, reviews.getReviewTargetId());
            st.setString(4, reviews.getReviewUserId());
            st.setString(5, reviews.getReviewContent());
            st.setString(6, reviews.getReviewDate());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return reviews;
    }

    @Override
    public List ArticleCatalog(String IdAuthor) {
        List list = new ArrayList();
        try {
            cn = db.open();

            String sql = "select IdArticle,ArticleTitle,ArticleType,ReleaseDate from article where IdArticleAuthor=? and status='1'";

            st = cn.prepareStatement(sql);

            st.setString(1, IdAuthor);

            rs = st.executeQuery();
//
            while (rs.next()) {
                String id = rs.getString("IdArticle");
                String title = rs.getString("ArticleTitle");
                String type = rs.getString("ArticleType");
                String date = rs.getString("ReleaseDate");
//
                Article article = new Article();
                article.setId(id);
                article.setType(type);
                article.setTitle(title);
                article.setDatetime(date);
//
                list.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return list;
    }

    @Override
    public List AllArticleCatalogs() {
        List list = new ArrayList();
        try {
            cn = db.open();

            String sql = "select u.usersName,a.* from article a\n" +
                    "join users u on u.id_Users = a.IdArticleAuthor\n" +
                    "where a.status='1' order by a.ReleaseDate desc ;";

            st = cn.prepareStatement(sql);

            rs = st.executeQuery();
//
            while (rs.next()) {
                String authorName = rs.getString("usersName");
                String id = rs.getString("IdArticle");
                String title = rs.getString("ArticleTitle");
                String type = rs.getString("ArticleType");
                String date = rs.getString("ReleaseDate");
//
                Article article = new Article();
                article.setIdAuthor(authorName);
                article.setId(id);
                article.setType(type);
                article.setTitle(title);
                article.setDatetime(date);
//
                list.add(article);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return list;
    }

    @Override
    public List allArticlesByKey(String key) {
        List list = new ArrayList();
        try {
            cn = db.open();
//            感觉这个方法应该能和上一个合并，暂时没想好，还有模糊查询的分词功能也没写，like匹配在大体量的数据就不行了。
            String sql = "select u.usersName,a.* from article a\n" +
                    "join users u on u.id_Users = a.IdArticleAuthor where " +
                    "a.status='1' and  a.ArticleTitle " +
                    "like ? or a.ArticleType like ? or a.ReleaseDate like ?" +
                    "order by a.ReleaseDate desc;";

            st = cn.prepareStatement(sql);
//            String key1 ="%"+key+"%";
            st.setString(1,"%"+key+"%");
            st.setString(2,"%"+key+"%");
            st.setString(3,"%"+key+"%");

            rs = st.executeQuery();
//
            while (rs.next()) {
                String authorName = rs.getString("usersName");
                String id = rs.getString("IdArticle");
                String title = rs.getString("ArticleTitle");
                String type = rs.getString("ArticleType");
                String date = rs.getString("ReleaseDate");
//
                Article article = new Article();
                article.setIdAuthor(authorName);
                article.setId(id);
                article.setType(type);
                article.setTitle(title);
                article.setDatetime(date);
//
                list.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return list;
    }

    @Override
    public int updateArticle(Article article) {
        int ret = 0;
        try {
            cn = db.open();
            String sql1 = "update blog.article set ArticleTitle = ? ," +
                    "ArticleType = ? , ArticleContent = ? ,ReleaseDate = ? where IdArticle = ?";

            st = cn.prepareStatement(sql1);
//          给文章添加更新时间
            article.setDatetime(id.date());

            st.setString(1, article.getTitle());
            st.setString(2, article.getType());
            st.setString(3, article.getContent());
            st.setString(4, article.getDatetime());
            st.setString(5, article.getId());
//根据更新后的大小来判断是否更新成功
            ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return ret;
    }

}
