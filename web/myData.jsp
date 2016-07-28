<%-- 
    Document   : myData
    Created on : Jul 25, 2016, 9:16:26 AM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.JumsHelper"
        import="java.util.ArrayList"
        import="jums.ItemBeans"
        import="java.util.HashMap"
        import="jums.UserDataBeans"%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans) session.getAttribute("userData");
    UserDataBeans login = (UserDataBeans) session.getAttribute("login");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザー情報</title>
    </head>
    <body>
        <h1>ユーザー情報</h1>
        
        ユーザー名:<%= udb.getName()%><br>
        パスワード:<%= udb.getPassword()%><br>
        メールアドレス:<%= udb.getEmail()%><br>
        住所:<%= udb.getAddress()%><br>
        購入総額:<%= udb.getTotal()%><br>
        
       
        <form action="MyHistory" method="post">
            <input type="submit" value="購入履歴" name="ToMyHistory">  
        </form>
        <form action="MyUpdate" method="post">
            <input type="submit" value="更新" name="ToMyUpdate">  
        </form>
        <form action="MyDelete" method="post">
            <input type="submit" value="削除" name="ToMyDelete">  
        </form>
        <%= jh.loginCheck(login) %>
    </body>
</html>
