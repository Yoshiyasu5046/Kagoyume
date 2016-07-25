<%-- 
    Document   : search2
    Created on : Jul 25, 2016, 11:11:07 AM
    Author     : yoshiyasukitahara
--%>
<%@page import="jums.JumsHelper"
        import="java.util.ArrayList"
        import="jums.ItemBeans"
        import="jums.UserDataBeans"%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<ItemBeans> ib = (ArrayList<ItemBeans>) session.getAttribute("SearchResult");
    UserDataBeans udb = (UserDataBeans) session.getAttribute("Login");
    String searchWord = (String) request.getAttribute("searchWord");
%>
    

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品検索結果</title>
    </head>
    <body>
        <h1>商品検索結果</h1>
        <h3>検索ワード:<%= searchWord%></h3>
        <h3>検索結果数<%= ib.size()%></h3>
        
        <table>
            <tr>
                <th>商品名</th>
                <th>価格</th>
                <th>画像</th>
            </tr>
            
            <% for (int i = 0; i < ib.size(); i++) { %>
            <tr>    
                <td width="400px"><a href="Item?id=<%= ib.get(i).getCode()%>"><%= ib.get(i).getName()%></td>
                <td><%= ib.get(i).getPrice()%>円</td>
                <td><img src="<%= ib.get(i).getImage()%>"></td>
            </tr>
            <% } %>
            
        </table>
        <br><br>
        <%= jh.login()%>
    </body>
</html>
