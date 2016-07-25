/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 *
 * @author yoshiyasukitahara
 */

public class YahooConnect implements Serializable {
    private static String baseUri = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
    private static String appId = "dj0zaiZpPUNJcFFqUndOZlhDWCZzPWNvbnN1bWVyc2VjcmV0Jng9ZDM-";
    private static String baseUriId = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup";
    
    
    public static YahooConnect getInstance() {
        return new YahooConnect();
    }

    
    public static ArrayList<ItemBeans> search(String searchWord){
        ArrayList<ItemBeans> al = new ArrayList();
        String result = "";
        try{
            searchWord = URLEncoder.encode(searchWord, "utf-8");
            URL url = new URL(baseUri + "?appid=" + appId + "&query=" + searchWord);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
            while ((tmp = in.readLine()) != null) {
                result += tmp;
            }

            // jsonメソッドを作成。
            JsonNode head = null;
            JsonFactory jfactory = new JsonFactory();
            JsonParser parser = jfactory.createParser(result);
            ObjectMapper mapper = new ObjectMapper();
            head = mapper.readTree(parser);
            
            for (int i = 0; i < 20; i++) {
                ItemBeans ib = new ItemBeans();
                String str = String.valueOf(i);
                ib.setName(head.get("ResultSet").get("0").get("Result").get(str).get("Name").textValue());
                ib.setPrice(head.get("ResultSet").get("0").get("Result").get(str).get("Price").get("_value").textValue());
                ib.setImage(head.get("ResultSet").get("0").get("Result").get(str).get("Image").get("Medium").textValue());
                ib.setCode(head.get("ResultSet").get("0").get("Result").get(str).get("Code").textValue());
                al.add(ib);
            }
            
            in.close();
            con.disconnect();
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return al;
    }
    


public static ArrayList<ItemBeans> searchById(String itemId) {
        ArrayList<ItemBeans> al = new ArrayList();
        String result = "";
        try{
            URL url = new URL(baseUriId + "?appid=" + appId + "&itemcode=" + itemId + "&responsegroup=medium");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
            while ((tmp = in.readLine()) != null) {
                result += tmp;
            }

            // jsonメソッドを作成。
            JsonNode head = null;
            JsonFactory jfactory = new JsonFactory();
            JsonParser parser = jfactory.createParser(result);
            ObjectMapper mapper = new ObjectMapper();
            head = mapper.readTree(parser);
            
            
            ItemBeans ib = new ItemBeans();
            ib.setUrl(head.get("ResultSet").get("0").get("Result").get("0").get("Url").textValue());
            ib.setName(head.get("ResultSet").get("0").get("Result").get("0").get("Name").textValue());
            ib.setCode(head.get("ResultSet").get("0").get("Result").get("0").get("Code").textValue());
            ib.setPrice(head.get("ResultSet").get("0").get("Result").get("0").get("Price").get("_value").textValue());
            ib.setImage(head.get("ResultSet").get("0").get("Result").get("0").get("Image").get("Medium").textValue());
            ib.setDescription(head.get("ResultSet").get("0").get("Result").get("0").get("Description").textValue());
            ib.setRate(head.get("ResultSet").get("0").get("Result").get("0").get("Review").get("Rate").textValue());
            al.add(ib);
            
            
            in.close();
            con.disconnect();
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return al;
    }    
    
   
}
