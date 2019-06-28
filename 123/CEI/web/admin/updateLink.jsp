<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2019/6/18
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/linkServlet?op=updateLink&id=${link.id}" method="post">
    <table border="1">

        <tr>
            <td>路径</td>
            <td>
                <input type="file" name="path"   value="${link.path}" />
            </td>

        </tr>

        <tr>
            <td>图片名</td>
            <td>
                <input type="text" name="name" value="${link.name}"/>
            </td>

        </tr>

        <tr align="center">

            <td char="2">
                <input type="submit" value="修改内容" />
            </td>

        </tr>

    </table>

</form>
</body>
</html>
