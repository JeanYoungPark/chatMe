<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>chatMe</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/chat.css">
</head>

<body>

<div id="container" class="container">
    <div class="chat">
        <div id="header">
            <h1>
                <span>실시간 채팅 ( ${user.nickName} )</span>
            </h1>
            <a class="logout" href="/logout">로그아웃</a>
        </div>
        <div id="chatting" class="chatting">
        </div>

        <div id="msg">
            <div class="inputTable">
                <input id="sessionId" type="hidden" value="">
                <input id="userId" type="hidden" name="userId" value="${user.userId}">
                <input id="nickName" type="hidden" name="nickName" value="${user.nickName}">
                <textarea id="chat" placeholder="보내실 메시지를 입력하세요."></textarea>
                <button onclick="send()" id="sendBtn">전송</button>
            </div>
        </div>
    </div>
</div>
<script src="/js/main.js"></script>
</body>
</html>