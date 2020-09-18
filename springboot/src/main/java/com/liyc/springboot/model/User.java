package com.liyc.springboot.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyc
 * @since 2020-09-18
 */

public class User extends Model<MpUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long createTime;

    private String email;

    private String nickName;

    private String passWord;

    private String userName;

    @TableLogic
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"createTime\":")
                .append(createTime);
        sb.append(",\"email\":\"")
                .append(email).append('\"');
        sb.append(",\"nickName\":\"")
                .append(nickName).append('\"');
        sb.append(",\"passWord\":\"")
                .append(passWord).append('\"');
        sb.append(",\"userName\":\"")
                .append(userName).append('\"');
        sb.append(",\"deleted\":")
                .append(deleted);
        sb.append('}');
        return sb.toString();
    }
}
