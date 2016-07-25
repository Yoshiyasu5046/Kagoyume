/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

/**
 *
 * @author yoshiyasukitahara
 */
public class JumsHelper {
    
    // staticでないといけない理由？
    public static JumsHelper getInstance() {
        return new JumsHelper();
    }
    
    //ログインページへのリンクを定数として設定
    private final String loginURL = "Login";
    
    //トップへのリンクを返却
    public String login(){
        return "<a href=\""+ loginURL +"\">ログインページへ</a>";
    }
    
    //トップページへのリンクを定数として設定
    private final String topURL = "index.jsp";
    
    //トップへのリンクを返却
    public String top(){
        return "<a href=\""+ topURL +"\">トップページへ</a>";
    }
    
    //ログアウトへのリンクを定数として設定
    private final String logoutURL = "Logout";
    
    //トップへのリンクを返却
    public String logout(){
        return "<a href=\""+ logoutURL +"\">ログアウト</a>";
    }
}
