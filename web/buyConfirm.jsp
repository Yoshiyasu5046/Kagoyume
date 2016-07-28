<%-- 
    Document   : buyConfirm
    Created on : Jul 25, 2016, 8:43:48 AM
    Author     : yoshiyasukitahara
--%>

<%@page import="jums.JumsHelper"
        import="java.util.ArrayList"
        import="jums.ItemBeans"
        import="java.util.HashMap"
        import="jums.UserDataBeans" %>

<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<ArrayList> cart = (ArrayList) session.getAttribute("cart");
    UserDataBeans udb = new UserDataBeans();
    UserDataBeans login = (UserDataBeans) session.getAttribute("login");
    String referer = (String) session.getAttribute("toCart");
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
        <% if (cart.size() > 0) { %>
        <table>
            <tr>
            <th>商品名</th>
            <th>価格</th>
            </tr>
            
            <% for (int i = 0; i < cart.size(); i++) { 
                ArrayList<ItemBeans> cartContent = cart.get(i); %>
            <tr>
                <td><img src="<%= cartContent.get(0).getImage() %>"></td>
                <td> <%= cartContent.get(0).getName() %></td>
                <td> <%= cartContent.get(0).getPrice() %>円</td>
                <td>
                    <form action="Cart2" method="post">
                        <input type="submit" value="削除" name="deleteItem">
                        <input type="hidden" name="deletingItemIndex" value="<%= i%>">
                        <input type="hidden" name="deletingItem" value="deletingItem">
                    </form>
                </td>
               
            </tr>
        </table>
        <% } %>
        合計:<%= session.getAttribute("total")%>円<br><br>
        
        <form action="BuyComplete" method="post">
            <% for(int n = 1; n <= 3; n++){ %>
            <input type="radio" name="deliveryType" required value="<%=n%>"<%if(udb.getDeliveryType() == n){out.print("checked");}%>><%=jh.deliveryType(n)%><br>
           <% } %> 
           <br><br>
           <input type="submit" value="購入する" name="ToBuyComplete">  
        </form><br><br>
        <form action=" <%= referer%>" method="post">
            <input type="submit" value="カートへ" name="toCart">  
            <input type="hidden" name="deletingItem" value="deletingItem">
        </form>     
        <% } else { %>
        <h2>購入する商品がございません</h2><br><br>
        <% } %>
    
        <%= jh.loginCheck(login) %>
        
    </body>
</html>
