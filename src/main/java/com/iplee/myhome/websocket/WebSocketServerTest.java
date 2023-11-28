package com.iplee.myhome.websocket;

import org.springframework.stereotype.Service;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/websocket")
@Service
public class WebSocketServerTest {

    @OnMessage
    public void onMessage(Session session, String message) {
        try {
            // 클라이언트로부터 메시지를 받았을 때 동작할 코드
            System.out.println("Received message from client: " + message);

            // 클라이언트에게 응답을 보냄
            session.getBasicRemote().sendText("Server received your message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
