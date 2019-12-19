package liu.com.Entity;

public class Reviews {
    private String reviewId;//评论id，唯一，主键
    private String articleId;//评论文章的文章id
    private String reviewTargetId;//评论的目标评论id
    private String reviewUserId;//评论人id
    private String reviewName;//评论人名字
    private String reviewCUserId;//被评论人id
    private String reviewCName;//被评论人名字
    private String reviewContent;//评论内容
    private String reviewDate;//评论时间

    public Reviews() {
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getReviewTargetId() {
        return reviewTargetId;
    }

    public void setReviewTargetId(String reviewTargetId) {
        this.reviewTargetId = reviewTargetId;
    }

    public String getReviewUserId() {
        return reviewUserId;
    }

    public void setReviewUserId(String reviewUserId) {
        this.reviewUserId = reviewUserId;
    }

    public String getReviewName() {
        return reviewName;
    }

    public String getReviewCUserId() {
        return reviewCUserId;
    }

    public void setReviewCUserId(String reviewCUserId) {
        this.reviewCUserId = reviewCUserId;
    }

    public String getReviewCName() {
        return reviewCName;
    }

    public void setReviewCName(String reviewCName) {
        this.reviewCName = reviewCName;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }
}
