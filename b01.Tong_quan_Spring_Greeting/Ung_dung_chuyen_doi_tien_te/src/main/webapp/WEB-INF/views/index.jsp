<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action = "/convert" method="post">
    <div>USD: <input name="usd" value="${usd}"></div>
    <div>Result: <input name="result" value="${res}"></div>
    <button>Convert</button>
</form>
</body>
</html>
