package top.itodouble.sso.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws/message/{token}")
@Component
public class MessageWebSocketController {
}
