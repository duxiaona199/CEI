<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2019/6/16
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@  taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <table border="1" width="438">

        <c:forEach items="${list}" var="item">

            <tr>
                <td> ${item.id}</td>
                <td> ${item.path}</td>
                <td> ${item.name}</td>
                <td>
                  <a href="JavaScript:delLink('${item.id}')">    删除    </a>
                    <a href="${pageContext.request.contextPath}/linkServlet?op=editLink&id=${item.id}">   修改   </a>
                </td>
            </tr>
        </c:forEach>

</table>
</body>
</html>
<<script>
     
       function delLink(id) {

         var  sure = confirm("你确定要删除吗");
         if (sure){
           window.location.href = "${pageContext.request.contextPath}/linkServlet?op=delLink&id="+id;
        }else{
             alert("NoOk");
        }

     }

</script>>
