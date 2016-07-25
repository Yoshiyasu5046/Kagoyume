<%-- 
    Document   : regisrationConfirm
    Created on : Jul 22, 2016, 2:34:36 PM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans" %>

<%
  JumsHelper jh = JumsHelper.getInstance();
  UserDataBeans udb = (UserDataBeans) session.getAttribute("udb");  
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録情報確認</title>
    </head>
    <body>
        <h1>登録情報確認</h1>
        名前:<%= udb.getName()%><br>
<!--        パスワードは非表示にした方がいいかな-->
        パスワード:<%= udb.getPassword()%><br> 
        Eメール:<%= udb.getEmail()%><br>
        住所:<%= udb.getAddress()%><br>
        上記の内容で登録します。よろしいですか？<br><br>
        
        <form action="RegisrationComplete" method="POST">
            <input type="submit" name="yes" value="はい"><br><br>
            <!--　直リンクを防止するためにフォームで乱数を送信-->
        </form>
         
        <!-- 課題2　直リンク防止のための処理 ここで乱数を送る必要はない。-->
        <form action="Regisration" method="POST">
            <input type="hidden" name="mode" value="REINPUT"> 
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
    </body>
</html>
