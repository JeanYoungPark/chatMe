package com.example.chatme.handler;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;

@Component
public class SocketHandler extends TextWebSocketHandler {

    private final Logger log = LoggerFactory.getLogger(SocketHandler.class);

    //웹소켓 세션을 담아둔다.
    HashMap<String, WebSocketSession> sessionMap = new HashMap<>();

    //메시지 수신시 동작
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        //메세지 받는다.
        String msg = message.getPayload();
        JSONObject obj = jsonToObjectParser(msg);

        for (String key: sessionMap.keySet()){
            WebSocketSession wss = sessionMap.get(key);
            try {
                wss.sendMessage(new TextMessage(obj.toJSONString()));
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    //웹 소켓이 연결되면 동작
    @SuppressWarnings("unchecked")
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessionMap.put(session.getId(), session);
        JSONObject obj = new JSONObject();
        obj.put("type", "getId");
        obj.put("sessionId", session.getId());
        session.sendMessage((new TextMessage(obj.toJSONString())));
    }

    //웹 소켓이 종료되면 동작
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.remove(session.getId());
        super.afterConnectionClosed(session, status);
    }

    //json파일 파씽
    private static JSONObject jsonToObjectParser(String jsonStr){
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try{
            obj = (JSONObject) parser.parse(jsonStr);
        } catch(ParseException e){
            e.printStackTrace();
        }
        return obj;
    }

}
