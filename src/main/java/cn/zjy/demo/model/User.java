package cn.zjy.demo.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.annotations.AutomapConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZJY
 * @ClassName: User
 * @Description: User
 * @date 2018/8/1 14:18
 */
@TableName("demo_user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 7212856431205663278L;

    @TableId(type = IdType.AUTO)
    @TableField("user_id")
    private Integer userId;

    @TableField("mobile")
    private String mobile;

    @TableField("name")
    private String name;

    @TableField("email")
    private String email;

    @TableField("age")
    private Integer age;

    @TableField("other_contact")
    private String otherContact;

    @TableField("status")
    private Integer status;

    /**
     * jackson是springboot默认的json序列化工具，加上该配置可以指定日期序列化的格式，不会变成时间戳的格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time", insertStrategy = FieldStrategy.NEVER)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Date updateTime;


    @AutomapConstructor
    public User(Integer userId, String mobile, String name, String email, Integer age, String otherContact, Date createTime, Date updateTime, Integer status) {
        this.userId = userId;
        this.mobile = mobile;
        this.name = name;
        this.email = email;
        this.age = age;
        this.otherContact = otherContact;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

}