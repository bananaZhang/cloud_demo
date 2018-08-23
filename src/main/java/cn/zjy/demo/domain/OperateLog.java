package cn.zjy.demo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZJY
 * @ClassName: OperateLog
 * @Description: OperateLog
 * @date 2018/8/22 20:09
 */
public class OperateLog implements Serializable {
    private static final long serialVersionUID = 4250390307833210410L;

    private Integer id;

    private Integer userId;

    private String oper;

    private String errorDesc;

    private String operDesc;

    private Integer status;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getOperDesc() {
        return operDesc;
    }

    public void setOperDesc(String operDesc) {
        this.operDesc = operDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OperateLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", oper='" + oper + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", operDesc='" + operDesc + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
