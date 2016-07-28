<%-- 
    Document   : buyComplete
    Created on : Jul 25, 2016, 10:50:30 PM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans login = (UserDataBeans) session.getAttribute("login");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入結果</title>
    </head>
    <body>
        <h1>購入結果</h1>
        <h2>購入が完了しました</h2>
        <br><br>
        
        <%= jh.top() %> <br><br>
        <%= jh.loginCheck(login) %>
    </body>
</html>
