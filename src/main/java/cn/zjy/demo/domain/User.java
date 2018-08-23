package cn.zjy.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZJY
 * @ClassName: User
 * @Description: User
 * @date 2018/8/1 14:18
 */
public class User implements Serializable {

    private static final long serialVersionUID = 7212856431205663278L;

    private Integer userId;

    private String mobile;

    private String name;

    private String email;

    private String otherContact;

    /**
     * jackson是springboot默认的json序列化工具，加上该配置可以指定日期序列化的格式，不会变成时间戳的格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOtherContact() {
        return otherContact;
    }

    public void setOtherContact(String otherContact) {
        this.otherContact = otherContact;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", otherContact='" + otherContact + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
