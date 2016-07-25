<%-- 
    Document   : buyConfirm
    Created on : Jul 25, 2016, 8:43:48 AM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.JumsHelper"
        import="java.util.ArrayList"
        import="jums.ItemBeans"
        import="java.util.HashMap" %>

<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<ArrayList> cart = (ArrayList) session.getAttribute("cart");
    String referer = (String) request.getAttribute("toCart");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入確認</title>
    </head>
    <body>
        <h1>購入確認</h1>
        <table>
            <tr>
            <th>商品名</th>
            <th>価格</th>
            </tr>
            
            <tr>
                <% for (int i = 0; i < cart.size(); i++) { %>
                <td> <%= cart.get(i).get(1)%></td>
                <td> <%= cart.get(i).get(2)%>円</td>
                <% } %>
            </tr>
        </table>
        合計:<%= session.getAttribute("total")%>円<br><br>
        <form action="BuyComplete" method="post">
            <input type="submit" value="購入確認ページヘ" name="ToBuyConfirm">  
        </form><br><br>
        <form action=" <%= referer%>" method="post">
            <input type="submit" value="カートへ" name="toCart">  
        </form>     
    </body>
</html>
