package cn.zjy.demo.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ZJY
 * @ClassName: OperateLog
 * @Description: OperateLog
 * @date 2018/8/22 20:09
 */
@Table(name = "demo_operate_log")
@Data
public class OperateLog implements Serializable {
    private static final long serialVersionUID = 4250390307833210410L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "oper")
    private String oper;

    @Column(name = "error_desc")
    private String errorDesc;

    @Column(name = "oper_desc")
    private String operDesc;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_time")
    private Date createTime;
}
