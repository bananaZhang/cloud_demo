package cn.zjy.demo.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZJY
 * @ClassName: WebSocket
 * @Description: WebSocket
 * @date 2019/4/3 15:26
 */
@ServerEndpoint(value = "/demo/socket/{userId}")
@Component
@Slf4j
public class WebSocket {
    private Session session;

    private static Map<Integer, Session> userSessionMap = new ConcurrentHashMap<>();

    @OnOpen
    public void open(Session session, @PathParam(value = "userId") Integer userId) {
        this.session = session;
        userSessionMap.put(userId, session);

        log.debug("用户:{}连接上服务", userId);
    }

    public static void sendMsg(String msg, Integer userId) {
        Session session = userSessionMap.get(userId);
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
