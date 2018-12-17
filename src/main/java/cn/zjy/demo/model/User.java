package cn.zjy.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ZJY
 * @ClassName: User
 * @Description: User
 * @date 2018/8/1 14:18
 */
@Table(name = "demo_user")
@Data
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 7212856431205663278L;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "other_contact")
    private String otherContact;

    /**
     * jackson是springboot默认的json序列化工具，加上该配置可以指定日期序列化的格式，不会变成时间戳的格式
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "status")
    private Integer status;
}
