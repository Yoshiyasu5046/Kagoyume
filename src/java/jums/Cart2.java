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
public class Cart2 extends HttpServlet {

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
                ArrayList<ItemBeans> cartContent = (ArrayList) session.getAttribute("detail");
                
                Object obj = session.getAttribute("total");
                String objStr = obj.toString();
                int total = new Integer(objStr);
                udb.setTotal(total);
                
                if (udb.getTotal() == 0) {
                    total = 0;
                } else {
                    total = udb.getTotal();
                }
                
                // totalを更新。
                String deletingItem = request.getParameter("deletingItem");
                if (deletingItem != null) {
                    total = Integer.parseInt(cartContent.get(0).getPrice());
                }else {
                    total += Integer.parseInt(cartContent.get(0).getPrice());
                }
               
                // カートから商品を削除する。
                String deletedItemIndex = request.getParameter("deletingItemIndex");
                if (deletedItemIndex != null) {
                    int deletingItemIndex = Integer.parseInt(deletedItemIndex);
                    ArrayList<ArrayList> cart = (ArrayList) session.getAttribute("cart");
                    ArrayList<ItemBeans> item = new ArrayList<>();
                    if (cart.size() > 0) {
                        item = cart.get(deletingItemIndex);
                        total -= Integer.parseInt(item.get(0).getPrice());
                    }
                    cart.remove(deletingItemIndex);
                    session.setAttribute("cart", cart);
                }
                
                // カート内商品の合計金額の取得 
                udb.setTotal(total);
                session.setAttribute("total", total);
                
                Log.LogWrite("カートに移動しました。");
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            
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
