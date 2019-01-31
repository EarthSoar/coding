<%--
  Created by IntelliJ IDEA.
  User: Willing
  Date: 2019/1/31
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>AGE</th>
        </tr>
        <s:iterator value="#employees">
            <tr>
                <td><s:property value="id"/> </td>
                <td><s:property value="name"/> </td>
                <td><s:property value="age"/> </td>
                <t
            </tr>
        </s:iterator>
    </table>
</body>
</html>
