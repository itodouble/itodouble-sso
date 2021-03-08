package top.itodouble.sso.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/webSocket/{userId}")
@Component
public class WebSocketServer {
	private static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

	//concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
	private static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();

	//发送消息
	public void sendMessage(Session session, String message) throws IOException {
		if(session != null){
			synchronized (session) {
				//logger.info("WS服务：向客户端({})发送信息：{} " , sessionGetId(session),message);
				session.getBasicRemote().sendText(message);
			}
		}
	}

	public String sessionGetId(Session session ){
		return session.toString().split("\\@")[1];
	}

	//关闭连接时调用
	@OnClose
	public void onClose(Session session, @PathParam(value = "token") String token){

		logger.info("WS服务：{}(会话Id：{})连接断开！",token);

	}


	//收到客户端信息
	@OnMessage
	public void onMessage(Session session,String message) throws IOException{
		logger.info("WS服务：收到客户端消息：{}", message);

	}

	//错误时调用
	@OnError
	public void onError(Session session, Throwable throwable){
		logger.error("WS服务：Websock发生错误");
		logger.error(throwable.getMessage(), throwable);
		throwable.printStackTrace();
	}
}
