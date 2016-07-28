/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.sql.Timestamp;
/**
 * @author user1
 * ユーザー情報を格納するBeansオブジェクト。型やフィールド名がＤＢと連携している
 * データベースからの格納、取り出しで取得されたデータを最初に格納する
 */
public class UserDataDTO {
    private int userID = 0;
    private String name; 
    private String password;
    private String mail;
    private String address;
    private String code;
    private int deliveryType = 0;
    private int total = 0;
    private Timestamp date;
    private int deleteFlg = 0;
    private int price = 0;
    private String goodName;
    private String image;
    
    public UserDataDTO(){}
        
    public int getUserID(){ 
        return this.userID;
    }
    public void setUserID(int id){
        this.userID = id;
    }
    
    public String getName(){ 
        return this.name;
    }
    public void setName(String name){ 
        this.name = name;
    }
    
    public String getPassword(){ 
        return this.password;
    }
    public void setPassword(String pw){ 
        this.password = pw;
    }
    
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    public int getDeliveryType() {
        return this.deliveryType;
    }
    public void setDeliveryType(int deliveryType) {
        this.deliveryType = deliveryType;
    }
    
    public String getEmail(){ 
        return this.mail;
    }
    public void setEmail(String mail){ 
        this.mail = mail;
    }
    
    public String getAddress(){ 
        return this.address;
    }
    public void setAddress(String address){ 
        this.address = address;
    }
    
    public int getTotal(){ 
        return this.total;
    }
    public void setTotal(int total){ 
        this.total = total;
    }
    
    public Timestamp getDate(){ 
        return this.date;
    }
    public void setDate(Timestamp date){ 
        this.date = date;
    }
    
    public int getDeleteFlag(){ 
        return this.deleteFlg;
    }
    public void setDeleteFlag(int df){ 
        this.deleteFlg = df;
    }
    
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getGoodName() {
        return this.goodName;
    }
    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
    
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }


}
