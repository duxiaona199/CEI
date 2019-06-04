<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2019/5/29
  Time: 8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form id="MyForm">
    用户名： <input type="text" name="username" >
    密码： <input type="text" name="password" >
    性别： <input type="text" name="sex" >
    <input type="button"  id="btn" value="添加用户">
  </form>


  </body>
</html>
<script>
    $(function () {
        $("#btn").click(function () {
            $.ajax({
                url:"/UserServlet",
                type:"post",
                data:$("#MyForm").serialize(),
                success:function(data){
                    alert(data);
                },
                error:function(data){
                    alert(data);
                }
            });
        }) ;
    });
</script>
