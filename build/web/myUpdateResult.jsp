<%-- 
    Document   : myUpdateResult
    Created on : Jul 26, 2016, 4:24:35 PM
    Author     : yoshiyasukitahara
--%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans" %>

<%
  JumsHelper jh = JumsHelper.getInstance();
  UserDataBeans udb = (UserDataBeans) session.getAttribute("userData");  
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更新内容</title>
    </head>
    <body>
        <h1>登録内容</h1>
        名前:<%= udb.getName()%><br>
<!--        パスワードは非表示にした方がいいかな-->
        パスワード:<%= udb.getPassword()%><br> 
        Eメール:<%= udb.getEmail()%><br>
        住所:<%= udb.getAddress()%><br>
        購入総額:<%= udb.getTotal() %><br>
        上記の内容で登録しました。<br><br>
        <%= jh.top() %>
    </body>
</html>
