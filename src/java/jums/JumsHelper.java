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
    
    //myDataへのリンクを定数として設定
    private final String myDataURL = "MyData";
    
    //トップへのリンクを返却
    public String myData(){
        return "<a href=\""+ myDataURL +"\">マイページへ</a>";
    }
    
    public String deliveryType(int i) {
        switch(i){
            case 1:
                return "自宅配送";
            case 2:
                return "コンビニ受け取り";
            case 3:
                return "その他";
        }
        return "";
    }

//  login時は、logout, myCart, myDataを表示。それ以外の時は非表示にする。        
    public String loginCheck(UserDataBeans udb) {
        if (udb != null) {
            return logout();
        }
        return login();
    }


}
