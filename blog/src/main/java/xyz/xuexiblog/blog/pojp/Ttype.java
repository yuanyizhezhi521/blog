package xyz.xuexiblog.blog.pojp;

import java.io.Serializable;

public class Ttype implements Serializable {
    private Long id;

    private String name;
    private Tblog tblog;
    private Tuser tuser;

    public Tuser getTuser() {
        return tuser;
    }

    public void setTuser(Tuser tuser) {
        this.tuser = tuser;
    }

    public Tblog getTblog() {
        return tblog;
    }

    @Override
    public String toString() {
        return "Ttype{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tblog=" + tblog +
                ", tuser=" + tuser +
                '}';
    }

    public void setTblog(Tblog tblog) {
        this.tblog = tblog;
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