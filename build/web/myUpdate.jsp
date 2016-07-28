<%-- 
    Document   : myUpdate
    Created on : Jul 26, 2016, 2:36:24 PM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataBeans"%>
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
        <title>ユーザー情報を更新</title>
    </head>
    
    <body>
        <h1>ユーザー情報を更新</h1>
        <form action="MyUpdateResult" method="POST">
        ユーザー名:
        <input type="text" name="name" value="<%= ud.getName()%>">
        <br><br>

        パスワード:
        <input type="password" name="password" value="<%= ud.getPassword()%>">
        <br><br>

        Eメール:
        <input type="email" name="email" value="<%= ud.getEmail()%>">
        <br><br>
        
        住所:
        <input type="text" name="address" value="<%= ud.getAddress()%>">
        <br><br>
        
        購入総額:
        <input type="text" name="total" value="<%= ud.getTotal()%>">
        
        <br>
        <input type="submit" name="toMyUpdateResult" value="更新情報の確認へ">
     </form>
    <br>

    <form action="<%= session.getAttribute("referer")%>" method="POST">
        <input type="submit" name="back_to_myData" value="ユーザー情報ページへ"> 
    </form>
    
     <%= jh.loginCheck(login) %>

    </body>
</html>
