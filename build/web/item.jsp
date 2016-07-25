<%-- 
    Document   : item
    Created on : Jul 21, 2016, 2:14:54 PM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.JumsHelper"
        import="java.util.ArrayList"
        import="jums.ItemBeans" %>

<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<ItemBeans> ib = (ArrayList<ItemBeans>) session.getAttribute("detail");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品詳細</title>
    </head>
    <body>
        <h1>商品詳細</h1>
        <table>
            <tr>
            <th>商品ID</th>
            <th>商品名</th>
            <th>値段</th>
            <th>画像</th>
            <th>商品概要</th>
            <th>評価</th>
            </tr>
            
            <tr>
                
                <td> <%= ib.get(0).getCode()%></td>
                <td> <%= ib.get(0).getName()%></td>
                <td> <%= ib.get(0).getPrice()%>円</td>
                <td><img src="<%= ib.get(0).getImage()%>"></td>
                <td> <%= ib.get(0).getDescription()%></td>
                <td> <%= ib.get(0).getRate()%></td>
                
                <td>
                    <form action="Add" method="post">
                        <input type="submit" value="カートに追加" name="addToCart">
                    </form>
                </td>
            </tr>
        </table>
        <%= jh.login()%>
    </body>
</html>
