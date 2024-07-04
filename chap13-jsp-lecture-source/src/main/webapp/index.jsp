<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP</title>
</head>
<body>
<h1>JSP</h1>
<ul>
    <li>
        <a href="jsp/1_simpleJspStates.jsp">jsp 기록 문법</a>
    </li>
    <li>
        <a href="WEB-INF/testForward.jsp">testForward.jsp 직접 접근</a>
    </li>
</ul>
<hr>
<form action="/member" method="post">
    <input type="text" name="name"><br/>
    <input type="submit" value="전송">
</form>
</body>
</html>