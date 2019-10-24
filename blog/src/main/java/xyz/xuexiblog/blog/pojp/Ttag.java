package xyz.xuexiblog.blog.pojp;

import java.io.Serializable;

public class Ttag implements Serializable {
    private Long id;

    private String name;
    private Tblog tblog;
    private Tuser tuser;

    public Tblog getTblog() {
        return tblog;
    }

    public void setTblog(Tblog tblog) {
        this.tblog = tblog;
    }

    public Tuser getTuser() {
        return tuser;
    }

    public void setTuser(Tuser tuser) {
        this.tuser = tuser;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}