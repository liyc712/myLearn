package com.liyc.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author lyc
 * @Date 2020-9-14 17:25
 * @ClassName User
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -4251943705524954282L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true, unique = true)
    private String nickName;
    @Column(nullable = false)
    private Long createTime;
    //----------------------get set---------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"userName\":\"")
                .append(userName).append('\"');
        sb.append(",\"passWord\":\"")
                .append(passWord).append('\"');
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"nickName\":\"")
                .append(nickName).append('\"');
        sb.append(",\"createTime\":")
                .append(createTime);
        sb.append('}');
        return sb.toString();
    }
    //----------------------get set---------------------------------------------
}
