<%-- 
    Document   : regisration
    Created on : Jul 22, 2016, 2:06:33 PM
    Author     : yoshiyasukitahara
--%>

<%@page import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>

<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        udb = (UserDataBeans)hs.getAttribute("udb");
    }
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規ユーザー登録</title>
    </head>
    <body>
        <h1>新規ユーザー登録</h1>
        <form action="RegisrationConfirm" method="POST">
        
            ユーザー名:
            <input type="text" name="name" required value="<% if(reinput){out.print(udb.getName());}%>"><br>

            パスワード:
            <input 
                type="password" 
                name="password" 
                required
                value=""
            ><br>
            
            メールアドレス:
            <input type="email" name="email" value="<% if(reinput){out.print(udb.getEmail());}%>"><br>
            
            住所:
            <input type="text" name="address" value="<% if(reinput){out.print(udb.getAddress());}%>"><br><br>

            <input type="submit" name="yes" value="登録"><br>
            <!--　直リンクを防止するためにフォームで乱数を送信-->
        </form>
    </body>
</html>
