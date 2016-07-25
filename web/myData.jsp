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
    ArrayList<ArrayList> login = (ArrayList) session.getAttribute("Login");
    UserDataBeans udb = (UserDataBeans) request.getSession();
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
        
        <h1>詳細情報</h1>
        <% if (login != null) { %>
        名前:<%= login.get(1).udb.getName()%><br>
        メールアドレス:<%= login.get(3).udb.getEmail()%><br>
        住所:<%= login.get(4).udb.getAddress()%><br>
        購入総額:<%= login.get(5).udb.getTotal()%><br>
        <% } %>
       
        <form action="MyHistory" method="post">
            <input type="submit" value="購入履歴" name="ToBuyConfirm">  
        </form>
        <form action="MyUpdate" method="post">
            <input type="submit" value="更新" name="ToBuyConfirm">  
        </form>
        <form action="MyDelete" method="post">
            <input type="submit" value="削除" name="ToBuyConfirm">  
        </form>
    </body>
</html>
