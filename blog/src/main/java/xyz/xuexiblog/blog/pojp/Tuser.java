package xyz.xuexiblog.blog.pojp;

import java.io.Serializable;
import java.util.Date;

public class Tuser implements Serializable {
    private Long id;

    private String avatar;

    private Date createTime;

    private String email;

    private String nickname;

    private String password;

    private Integer type;

    @Override
    public String toString() {
        return "Tuser{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", updateTime=" + updateTime +
                ", username='" + username + '\'' +
                ", img='" + img + '\'' +
                ", identity=" + identity +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", favor='" + favor + '\'' +
                ", meno='" + meno + '\'' +
                ", Identity=" + Identity +
                '}';
    }

    private Date updateTime;

    private String username;

    private String img;

    private Integer identity;

    private String phone;

    private Integer gender;

    private String favor;

    private String meno;

    private int Identity;

    public void setIdentity(int identity) {
        Identity = identity;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getFavor() {
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }
}