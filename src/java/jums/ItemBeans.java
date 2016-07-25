/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jums;

import java.io.Serializable;

/**
 *
 * @author yoshiyasukitahara
 */

public class ItemBeans implements Serializable {
    private String url;
    private String image;//146×146サイズ
    private String name;
    private String code; // 商品コード（商品ID）
    private String price;
    private String description;
    private String rate;

    public ItemBeans() {
        this.url = "";
        this.image = "";
        this.name = "";
        this.price = "";
        this.code = "";
        this.description = "";
        this.rate = "";
    }
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getRate() {
        return this.rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }


}
