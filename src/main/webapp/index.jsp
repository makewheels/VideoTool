<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8"/>
    <%--    <meta name="viewport"--%>
    <%--          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>--%>
<body>
<h2>Download by server & push to netdisk:</h2>
<form method="post" action="/VideoTool/downloadAndPush">
    <input style="height: 30px;width:380px;"
           placeholder="please paste url here" name="url"/>
    <br>
    <button style="margin-top:20px;margin-left:30px;height: 30px;width: 120px;"
            type="submit">SUBMIT
    </button>
</form>
</body>
</html>
