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
    private int total = 0;
    private Timestamp newDate;
    private int deleteFlg = 0;
    
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
    
    public Timestamp getNewDate(){ 
        return this.newDate;
    }
    public void setNewDate(Timestamp nd){ 
        this.newDate = nd;
    }
    
    public int getDeleteFlag(){ 
        return this.deleteFlg;
    }
    public void setDeleteFlag(int df){ 
        this.deleteFlg = df;
    }
    
    
}
