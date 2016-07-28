<%-- 
    Document   : myHistory
    Created on : Jul 26, 2016, 12:02:28 PM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.UserDataBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.ItemBeans"%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<ArrayList> cart = (ArrayList) session.getAttribute("cart");
    ItemBeans ib = new ItemBeans();
    UserDataBeans login = (UserDataBeans) session.getAttribute("login");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>購入履歴</title>
    </head>
    <body>
        <h1>購入履歴</h1>
 
        <table>
            <tr>
            <th>商品画像</th>
            <th>商品名</th>
            <th>価格</th>
            </tr>
                
            <% for (int i = 0; i < cart.size(); i++) { 
                ArrayList<ItemBeans> cartContent = cart.get(i); %>
            <tr>
                <td><img src="<%= cartContent.get(0).getImage() %>"></td>
                <td> <%= cartContent.get(0).getName() %></td>
                <td> <%= cartContent.get(0).getPrice() %>円</td>
                
            </tr>
             <% } %>
        </table>
        
       
        <%= JumsHelper.getInstance().top() %><br><br>
        <%= jh.loginCheck(login) %>
    </body>
</html>
