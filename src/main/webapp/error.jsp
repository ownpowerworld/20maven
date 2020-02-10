<%--<%@ taglib prefix="s" uri="/struts-tags" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: freddy-java
  Date: 4/2/20
  Time: 5:23 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>Forward</title>
</head>
<body>
出错啦!<h1>${fieldsErrors}</h1>

</body>
</html>
