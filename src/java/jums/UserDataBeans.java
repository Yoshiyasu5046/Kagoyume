/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author yoshiyasukitahara
 */
public class UserDataBeans implements Serializable {
    private int userID = 0;
    private String name;
    private String password;
    private String email;
    private String address;
    private int total = 0;
    private Timestamp newDate;
    private int deleteFlag = 0;
    
    // コンストラクターを作成
    public UserDataBeans() {
        
    }
    
    public UserDataBeans(String name, String password, String email, String address) {
        setName(name);
        setPassword(password);
        setEmail(email);
        setAddress(address);
        setTotal(total);
        setDeleteFlag(deleteFlag);
    }
    
    public UserDataBeans(String name, String password, String email, String address, Timestamp newDate) {
        setName(name);
        setPassword(password);
        setEmail(email);
        setAddress(address);
        setTimestamp(newDate);
    }
    
    public UserDataBeans(String name, String password, String email, String address, int total, Timestamp newDate, int deleteFlag) {
        setName(name);
        setPassword(password);
        setEmail(email);
        setAddress(address);
        setTotal(total);
        setTimestamp(newDate);
        setDeleteFlag(deleteFlag);
    }
    
    
    public int getUserID() {
        return this.userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    } 
    
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal() {
        return this.total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
            
    public Timestamp getTimestamp() {
        return this.newDate;
    }
    public void setTimestamp(Timestamp newDate) {
        this.newDate = newDate;
    }
    
    public int getDeleteFlag() {
        return this.deleteFlag;
    }
    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    
    public void Udb2dtoMapping(UserDataDTO dto) {
        dto.setName(this.name);
        dto.setPassword(this.password);
        dto.setEmail(this.email);
        dto.setTotal(this.total);
        dto.setAddress(this.address);
        dto.setDeleteFlag(this.deleteFlag);
    }

    public void Dto2UdbMapping(UserDataDTO dto) {
        this.userID = dto.getUserID();
        this.name = dto.getName();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
        this.total = dto.getTotal();
        this.address = dto.getAddress();
        this.deleteFlag = dto.getDeleteFlag();
    }
    
}
