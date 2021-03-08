package top.itodouble.sso.websocket;


import org.springframework.stereotype.Component;

import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws/user/{token}")
@Component
public class UserWebSocketController {
}
