package xyz.xuexiblog.blog.pojp;

import java.io.Serializable;

public class Tblogtags implements Serializable {
    private Long blogsId;

    private Long tagsId;

    private static final long serialVersionUID = 1L;

    public Long getBlogsId() {
        return blogsId;
    }

    public void setBlogsId(Long blogsId) {
        this.blogsId = blogsId;
    }

    public Long getTagsId() {
        return tagsId;
    }

    public void setTagsId(Long tagsId) {
        this.tagsId = tagsId;
    }
}