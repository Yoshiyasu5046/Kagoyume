/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;
import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author yoshiyasukitahara
 */
public class UserDataDAO {
    
    public static UserDataDAO getInstance() {
        return new UserDataDAO();
    }
    
    
    public void insert(UserDataDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name, password, mail, address, total, newDate, deleteFlg) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, dto.getName());
            // すでに作成されたパスワードと重複しないようにする。
            st.setString(2, dto.getPassword());
            st.setString(3, dto.getEmail());
            st.setString(4, dto.getAddress());
            st.setInt(5, dto.getTotal());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, dto.getDeleteFlag());
            st.executeUpdate();
            st.close();
            
//            Log.printLog("userdatainsert completed");

        } catch(Exception e) {
            System.out.println("エラーが出ました。");
        }
        finally{
            if(con != null){
                con.close();
            } if(st != null) {
                st.close();
            }
        }
    }
    
    public void login(UserDataDTO dto) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;    
        try {
            con = DBManager.getConnection();
            st =  con.prepareStatement("select * from user_t where name = ? and password = ?");
            st.setString(1, dto.getName());
            st.setString(2, dto.getPassword());
            
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                dto.setUserID(rs.getInt("userID"));
                dto.setName(rs.getString("name"));
                dto.setPassword(rs.getString("password"));
                dto.setEmail(rs.getString("email"));
                dto.setAddress(rs.getString("address"));
                dto.setTotal(rs.getInt("total"));
                dto.setNewDate(rs.getTimestamp("newDate"));
            }
            
            st.close();
            
        } catch (Exception e) {
            System.out.println("エラーが出ました。");
        } finally{
            if(con != null){
                con.close();
            } if(st != null) {
                st.close();
            }
        }
        
    }


}
