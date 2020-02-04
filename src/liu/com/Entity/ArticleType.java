package liu.com.Entity;

public class ArticleType {
    private String idarticletype;//文章类型id
    private String userId;//文章类型的拥有者
    private String typeContent;//文章类型名
    private String registerDate;//注册时间

    public ArticleType() {
    }

    public String getIdarticletype() {
        return idarticletype;
    }

    public void setIdarticletype(String idarticletype) {
        this.idarticletype = idarticletype;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}
