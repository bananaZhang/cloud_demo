package cn.zjy.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZJY
 * @ClassName: IpUtil
 * @Description: IpUtil
 * @date 2018/8/23 11:19
 */
public class IpUtil {
    private static Logger logger = LoggerFactory.getLogger(IpUtil.class);

    public static String getUserIpAddr(HttpServletRequest request) {
        //获取经过代理的客户端的IP地址; 排除了request.getRemoteAddr() 方法 在通过了Apache,Squid等反向代理软件就不能获取到客户端的真实IP地址了
        String ip = getIpAddr(request);
        if (ip != null && ip.indexOf(",") > 0) {
            logger.info("取到客户多个ip1====================" + ip);
            String[] arr = ip.split(",");
            ip = arr[arr.length - 1].trim();//有多个ip时取最后一个ip
            logger.info("取到客户多个ip2====================" + ip);
        }
        return ip;
    }

    private static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
