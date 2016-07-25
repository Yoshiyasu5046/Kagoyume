/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yoshiyasukitahara
 */
public class Cart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            
                // cart.jspでユーザーがアイテムを削除した場合の処理。
                HttpSession session = request.getSession();
                UserDataBeans udb = new UserDataBeans();
//                ArrayList<ArrayList> cart = (ArrayList) session.getAttribute("cart");
                ArrayList<ItemBeans> cartContent = (ArrayList) session.getAttribute("detail");
                
                // udb.getTotal()が1以上の場合、total = udb.getTotal()
                int total;
                if (udb.getTotal() == 0) {
                    total = 0;
                } else {
                    total = udb.getTotal();
                }
                
                // totalを更新し、DBに格納。
                total += Integer.parseInt(cartContent.get(0).getPrice());
                
                // cardContentをarrayListとしてcartに入れる。
//                cart.add(cartContent);
                 
                // カート内商品の合計金額の取得 
                udb.setTotal(total);
                session.setAttribute("total", total);
                
                // session"カート"に追加。
//                session.setAttribute("cart", cart);
                
                request.getRequestDispatcher("/cart.jsp").forward(request, response);
            
        }catch(Exception e) {
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
