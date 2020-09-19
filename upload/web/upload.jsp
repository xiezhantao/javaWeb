<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2020/7/22
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="http://localhost:8080/upload/uploadServlet" enctype="multipart/form-data" method="post">
    用户名: <input type="text" name="username">
    头像: <input type="file" name="photo">
    <input type="submit" value="提交">
</form>

</body>
</html>
