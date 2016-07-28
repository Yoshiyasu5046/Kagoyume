<%-- 
    Document   : myDelete
    Created on : Jul 27, 2016, 11:00:38 AM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans ud = (UserDataBeans) session.getAttribute("userData");
    UserDataBeans login = (UserDataBeans) session.getAttribute("login");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除したいユーザー情報</title>
    </head>
    
    <body>
        <h1>削除したいユーザー情報</h1>
        <form action="MyDeleteResult" method="POST">
            ユーザー名:<%= ud.getName()%>
            <br><br>

            パスワード:<%= ud.getPassword()%>
            <br><br>

            Eメール:<%= ud.getEmail()%>
            <br><br>

            住所:<%= ud.getAddress()%>
            <br><br>

            購入総額:<%= ud.getTotal()%>
            
        <br>
        <input type="submit" name="toMyDeleteResult" value="削除確定">
        </form>
    <br>

    <form action="<%= session.getAttribute("to_myData")%>" method="POST">
        <input type="submit" name="back_to_myData" value="ユーザー情報ページへ"> 
    </form>
    <%= jh.loginCheck(login) %>
    </body>
</html>
