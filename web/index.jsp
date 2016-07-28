<%-- 
    Document   : index
    Created on : Jul 20, 2016, 10:35:54 AM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
    
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans) session.getAttribute("login");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kagoyume</title>
    </head>
    <body>
        <h1>Kagoyume Top</h1>
        <form action="Search" method="GET">
            商品検索:
            <input type="text" name="search" required value="">
            <input type="submit" value="検索">
        </form><br>
        <%= jh.loginCheck(udb) %>
    </body>
</html>
