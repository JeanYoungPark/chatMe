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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class SocketHandler extends TextWebSocketHandler {

    private final Logger log = LoggerFactory.getLogger(SocketHandler.class);

    //웹소켓 세션을 담아둔다.
    //HashMap<String, WebSocketSession> sessionMap = new HashMap<>();
    List<HashMap<String, Object>> rls = new ArrayList<>();

    //메시지 수신시 동작
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        //메세지 받는다.
        String msg = message.getPayload();
        JSONObject obj = jsonToObjectParser(msg);

        String rn = (String) obj.get("roomNumber");
        HashMap<String, Object> temp = new HashMap<>();

        if(rls.size() > 0) {
            for (int i = 0; i < rls.size(); i++) {
                String roomNumber = (String) rls.get(i).get("roomNumber");  //세션리스트의 저장된 방번호
                if(roomNumber.equals(rn)) { //같은 값이 방이 존재한다면
                    temp = rls.get(i);
                    break;
                }
            }
        }

        //해당 방의 세션들만 찾아서 메시지 발송
        for (String key: temp.keySet()){
            if (key.equals("roomNumber")) { //방번호는 건너뛴다.
                continue;
            }

            WebSocketSession wss = (WebSocketSession) temp.get(key);
            if(wss != null) {
                try {
                    wss.sendMessage(new TextMessage(obj.toJSONString()));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    //웹 소켓이 연결되면 동작
    @SuppressWarnings("unchecked")
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        boolean flag = false;
        String url = session.getUri().toString();
        String roomNumber = url.split("/chating/")[1];
        int idx = rls.size();

        if(rls.size() > 0) {
            for (int i = 0; i < rls.size(); i++) {
                String rn = (String) rls.get(i).get("roomNumber");
                if (rn.equals(roomNumber)) {
                    flag = true;
                    idx = i;
                    break;
                }
            }
        }

        if(flag) { //존재하는 방이라면 세션만 추가
            HashMap<String, Object> map = rls.get(idx);
            map.put(session.getId(), session);
        }else { //최초 생성하는 방이라면 방번호와 세션 추가
            HashMap<String, Object> map = new HashMap<>();
            map.put("roomNumber", roomNumber);
            map.put(session.getId(), session);
            rls.add(map);
        }

        JSONObject obj = new JSONObject();
        obj.put("type", "getId");
        obj.put("sessionId", session.getId());
        session.sendMessage((new TextMessage(obj.toJSONString())));
    }

    //웹 소켓이 종료되면 동작
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        if(rls.size() > 0) {
            for (int i = 0; i < rls.size(); i++) {
                rls.get(i).remove(session.getId());
            }
        }

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
