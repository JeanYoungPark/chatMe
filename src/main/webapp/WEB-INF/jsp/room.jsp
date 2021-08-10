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
    <link rel="stylesheet" href="/css/room.css">
</head>

<body>

<div id="container" class="container">
    <div class="room">
        <div id="header">
            <h1>채팅방</h1>
            <span class="toggleBtn">+</span>
        </div>
        <div class="roomContainer">
            <table id="roomList"></table>
        </div>
        <div class="popup">
            <div class="bg">
                <span class="close">x</span>
                <span>방 제목</span>
                <span><input type="text" name="roomName" id="roomName"></span>
                <span><button id="createToom">방 만들기</button></span>
            </div>
        </div>
    </div>
</div>
<script src="/js/room.js"></script>
</body>
</html>