<%-- 
    Document   : cart
    Created on : Jul 24, 2016, 7:31:31 PM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.JumsHelper"
        import="java.util.ArrayList"
        import="jums.ItemBeans"
        import="java.util.HashMap"
        import="java.util.ArrayList" %>

<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<ArrayList> cart = (ArrayList) session.getAttribute("cart");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カート</title>
    </head>
    <body>
        <h1>カート</h1>
        <table>
            <tr>
            <th>商品画像</th>
            <th>商品名</th>
            <th>価格</th>
            <th>削除</th>
            </tr>
            
                
            <% for (int i = 0; i < cart.size(); i++) { 
                ArrayList<ItemBeans> cartContent = cart.get(i); %>
            <tr>
                <td><img src="<%= cartContent.get(0).getImage() %>"></td>
                <td> <%= cartContent.get(0).getName() %></td>
                <td> <%= cartContent.get(0).getPrice() %>円</td>
                <td>
                    <form action="Cart" method="post">
                        <input type="submit" value="削除" name="deleteItem">
                        <input type="hidden" name="deletingItem" value="<%= i%>">
                    </form>
                </td>
               
            </tr>
             <% } %>
        </table>
        合計:<%= session.getAttribute("total")%>円<br><br>
        <form action="BuyConfirm" method="post">
            <input type="submit" value="購入" name="ToBuyConfirm">  
        </form> <br><br>
        <a href="index.jsp">トップページへ</a>
    </body>
</html>
