package cn.zjy.demo.req;

import java.io.Serializable;

/**
 * @author ZJY
 * @ClassName: LoginReq
 * @Description: LoginReq
 * @date 2018/8/14 18:46
 */
public class LoginReq implements Serializable {

    private static final long serialVersionUID = -7300509383724126954L;

    private String mobile;

    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginReq{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
