package cn.zjy.demo.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZJY
 * @ClassName: OperateLog
 * @Description: OperateLog
 * @date 2018/8/22 20:09
 */
@TableName("demo_operate_log")
@Data
public class OperateLog implements Serializable {

    private static final long serialVersionUID = 4250390307833210410L;

    @TableId(type = IdType.AUTO)
    @TableField("id")
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("oper")
    private String oper;

    @TableField("oper_desc")
    private String operDesc;

    @TableField("status")
    private Integer status;

    @TableField("error_desc")
    private String errorDesc;

    @TableField(value = "update_time", insertStrategy = FieldStrategy.NEVER)
    private Date createTime;

    @TableField(value = "update_time", insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Date updateTime;
}
