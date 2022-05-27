<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Setting</h1>
<form action = "/update" method = "post">
    <div>
        Languages:
        <select name = "language">
            <option ${choice.language=='English'?'selected':''}>English</option>
            <option ${choice.language=='Vietnamese'?'selected':''}>Vietnamese</option>
            <option ${choice.language=='Japanese'?'selected':''}>Japanese</option>
            <option ${choice.language=='Chinese'?'selected':''}>Chinese</option>
        </select>
    </div>
    <div>
        Page Size:
        Show
        <select>
            <option ${choice.pageSize=='5'?'selected':''}>5</option>
            <option ${choice.pageSize=='10'?'selected':''}>10</option>
            <option ${choice.pageSize=='15'?'selected':''}>15</option>
            <option ${choice.pageSize=='25'?'selected':''}>25</option>
            <option ${choice.pageSize=='50'?'selected':''}>50</option>
            <option ${choice.pageSize=='100'?'selected':''}>100</option>
        </select>
        emails per page
    </div>
    <div>
        Spams filter:
        <input type="checkbox" ${choice.spamFilter ?'checked':''} name="spamsFilter">Enable spams filter
    </div>
    <div>
        Signature:
        <textarea name="signature">Thor King, Asgard</textarea>
    </div>
    <button>Update</button>
    <button>Cancel</button>
</form>
</body>
</html>
