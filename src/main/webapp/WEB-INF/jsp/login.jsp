<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/auth.css">
</head>

<body>
<div id="container" class="container">
    <div class="auth">
        <h1>로그인</h1>
        <div class="form">
            <form action="/auth/login" method="post">
                <p><input type="text" name="userId" placeholder="아이디를 입력해주세요"></p>
                <p><input type="password" name="password" placeholder="비밀번호를 입력해주세요"></p>
                <button type="submit">로그인</button>
            </form>
        </div>
        <p class="error">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
        <div class="joinBtn"><a href="/join">회원가입</a></div>
        <div>
            <span>소셜로그인</span>
            <div></div>
            <div></div>
        </div>
    </div>
</div>
</body>
</html>