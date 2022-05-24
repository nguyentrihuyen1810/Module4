<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Caculator</title>
</head>
<body>
<h1>Caculator</h1>
<form action = "/caculator" method="post">
  <div>
    <input type = "text" name = "number1">
    <input type = "text" name = "number2">
  </div>
  <div>
    <button type="submit" name = "operator" value="+">Addition(+)</button>
    <button type="submit" name = "operator" value="-">Subtraction(-)</button>
    <button type="submit" name = "operator" value="*">Multipcation(*)</button>
    <button type="submit" name = "operator" value="/">Division(/)</button>
  </div>
</form>
<div>Result = ${total}</div>
</body>
</html>
