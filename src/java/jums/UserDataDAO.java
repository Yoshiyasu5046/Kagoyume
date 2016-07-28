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
            
            Log.LogWrite("ユーザー情報を挿入または更新しました。");

        } catch(Exception e) {
            System.out.println("エラーが出ました。");
        }
        finally {
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
            if (rs.next()) {
                dto.setUserID(rs.getInt("userID"));
                dto.setName(rs.getString("name"));
                dto.setPassword(rs.getString("password"));
                dto.setEmail(rs.getString("email"));
                dto.setAddress(rs.getString("address"));
                dto.setTotal(rs.getInt("total"));
                dto.setDate(rs.getTimestamp("newDate"));
            }
            
            st.close();
            
            Log.LogWrite("ユーザーがログインしました。");
            
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
    
    public void delete(UserDataDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(deleteFlg) VALUES(?) where name = ?");
            st.setString(1, dto.getName());
            st.executeUpdate();
            st.close();
            
            Log.LogWrite("ユーザー情報を削除しました。正確にはdeleteFlagを1にしました。");

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
    
    public void buyRecord(UserDataDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO buy_t (userID, itemCode, type, buyDate) VALUES (?,?,?,?)");
            st.setInt(1, dto.getUserID());
            // すでに作成されたパスワードと重複しないようにする。
            st.setString(2, dto.getCode());
            st.setInt(3, dto.getDeliveryType());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            st.close();
            
            Log.LogWrite("購買情報をbuy_tに格納しました。");
        
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
    
    public void insertTotal(UserDataDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t (total) VALUES (?)");
            st.setInt(1, dto.getTotal());
            st.executeUpdate();
            st.close();
            
            Log.LogWrite("購入総額を更新しました");
            
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
        
    public UserDataDTO getUserData(UserDataDTO dto) throws SQLException{
        
        // 該当IDに合致するユーザー情報をDBから取得するための処理。
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st = con.prepareStatement(sql);
            st.setInt(1, dto.getUserID());
            
            ResultSet rs = st.executeQuery();
            
            // 上のIDを持つユーザー情報を返す。
            if (rs.next()) {
                dto.setUserID(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setPassword(rs.getString(3));
                dto.setEmail(rs.getString(4));
                dto.setAddress(rs.getString(5));
                dto.setTotal(rs.getInt(6));
                dto.setDate(rs.getTimestamp(7));
                dto.setDeleteFlag(rs.getInt(8));
            }
             
            System.out.println("search completed");

            return dto;
            
        }catch(SQLException e){
            System.out.println("検索結果が存在しません。");
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    
    
    public UserDataDTO getBuyRecord(UserDataDTO dto) throws SQLException{
        
        // 該当IDに合致するユーザー情報をDBから取得するための処理。
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM buy_t WHERE userID = ?";
            
            st = con.prepareStatement(sql);
            st.setInt(1, dto.getUserID());
            
            ResultSet rs = st.executeQuery();
            
            // 上のIDを持つユーザー情報を返す。
            if (rs.next()) {
                dto.setUserID(rs.getInt(1));
                dto.setCode(rs.getString(2));
            }
             
            System.out.println("search completed");

            return dto;
            
        }catch(SQLException e){
            System.out.println("検索結果が存在しません。");
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
  

}
