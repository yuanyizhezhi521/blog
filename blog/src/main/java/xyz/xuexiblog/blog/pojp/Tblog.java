package xyz.xuexiblog.blog.pojp;

import java.io.Serializable;
import java.util.Date;

public class Tblog implements Serializable {
    private Long id;

    private Boolean appreciation=false ;

    private Boolean commentabled=false;

    private Date createTime;

    private String description;

    private String firstPicture;

    private String flag;

    private Boolean published=false;

    private Boolean recommend=false;

    private Boolean shareStatement;

    private String title;

    private Date updateTime;

    private Integer views;

    private Long typeId;

    private Long userId;

    private String content;

    private Ttype ttype;

    private Tuser tuser;
    private Ttag ttag;

    public Ttag getTtag() {
        return ttag;
    }

    public void setTtag(Ttag ttag) {
        this.ttag = ttag;
    }

    public Tuser getTuser() {
        return tuser;
    }

    public void setTuser(Tuser tuser) {
        this.tuser = tuser;
    }

    public Ttype getTtype() {
        return ttype;
    }

    public void setTtype(Ttype ttype) {
        this.ttype = ttype;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Boolean appreciation) {
        if (appreciation==null&&appreciation.equals("")){
            this.appreciation =false;
        }else {
            this.appreciation = appreciation;
        }
    }

    public Boolean getCommentabled() {
        return commentabled;
    }

    public void setCommentabled(Boolean commentabled) {
        if (commentabled==null&&commentabled.equals("")){
            this.commentabled =false;
        }else {
            this.commentabled = commentabled;
        }

    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        if (published==null&&published.equals("")){
            this.published =false;
        }else {
            this.published = published;
        }
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        if (recommend==null&&recommend.equals("")){
            this.recommend =false;
        }else {
            this.recommend = recommend;
        }
    }

    public Boolean getShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(Boolean shareStatement) {
        if (shareStatement==null&&shareStatement.equals("")){
            this.shareStatement =false;
        }else {
            this.shareStatement = shareStatement;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}