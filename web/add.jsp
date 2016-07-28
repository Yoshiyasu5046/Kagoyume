<%-- 
    Document   : add
    Created on : Jul 22, 2016, 11:38:24 AM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"
        import="java.util.ArrayList"
        import="jums.ItemBeans"
        import="java.util.HashMap" %>

<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<ItemBeans> ib = (ArrayList) session.getAttribute("detail");
    UserDataBeans login = (UserDataBeans) session.getAttribute("login");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カート追加確認</title>
    </head>
    <body>      
        
        <h1>以下の商品をカートに追加できました</h1>
        <table>
            <tr>
            <th>商品画像</th>
            <th>商品名</th>
            <th>価格</th>
            <th>評価</th>
            </tr>
            
            <tr>
                <td><img src="<%= ib.get(0).getImage()%>"></td>
                <td> <%= ib.get(0).getName()%></td>
                <td> <%= ib.get(0).getPrice()%>円</td>
                <td> <%= ib.get(0).getRate()%></td>
                <td>
                    <form action="Cart2" method="post">
                        <input type="submit" value="カートへ" name="ToCart">  
                    </form>
                </td>
            </tr>
        </table>
      
    <%= jh.loginCheck(login) %>
    </body>
</html>
