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
public class Json {
            
    public JsonNode JsonParse(URL url) {
        JsonNode head = null;
        try {
            String result = "";
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tmp = "";
            while ((tmp = in.readLine()) != null) {
                result += tmp;
            }

            // jsonメソッドを作成。
            JsonFactory jfactory = new JsonFactory();
            JsonParser parser = jfactory.createParser(result);
            ObjectMapper mapper = new ObjectMapper();
            head = mapper.readTree(parser);
            return head;
            
        } catch (Exception IOException ) {
            IOException.printStackTrace();
        }
        return head;
    }
            
}
