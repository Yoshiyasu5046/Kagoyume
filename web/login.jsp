<%-- 
    Document   : login
    Created on : Jul 22, 2016, 1:16:25 PM
    Author     : yoshiyasukitahara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインPage</title>
    </head>
    <body>
        <h1>ログインページ</h1>
        <form action="LoginResult" method="post">
            ユーザー名: <input type="text" name="userName" value=""><br>
            パスワード: <input type="password" name="password" value="" ><br>
            <input type="submit" name="loginSubmit" value="確認画面へ"><br>    
        </form>
        
<!--        ログイン結果をどこに飛ばすべきか？-->
        
        <form action="Regisration" method="post">
            <input type="submit" name="regisrationSubmit" value="新規登録ページへ">
        </form>
         
    </body>
</html>
