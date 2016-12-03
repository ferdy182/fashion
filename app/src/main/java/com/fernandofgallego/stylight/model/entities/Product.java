
package com.fernandofgallego.stylight.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Product {

    @SerializedName("available")
    @Expose
    private Boolean available;
    @SerializedName("brand")
    @Expose
    private Brand brand;
    @SerializedName("shop")
    @Expose
    private Shop shop;
    @SerializedName("currency")
    @Expose
    private Currency currency;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("masterProductId")
    @Expose
    private Integer masterProductId;
    @SerializedName("hasUnits")
    @Expose
    private Boolean hasUnits;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("shopLink")
    @Expose
    private String shopLink;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("savings")
    @Expose
    private Double savings;
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<Image>();
    @SerializedName("sale")
    @Expose
    private Boolean sale;
    @SerializedName("shippingCost")
    @Expose
    private Double shippingCost;
    @SerializedName("checkoutId")
    @Expose
    private String checkoutId;
    @SerializedName("vertical")
    @Expose
    private String vertical;

    /**
     * 
     * @return
     *     The available
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * 
     * @param available
     *     The available
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    /**
     * 
     * @return
     *     The brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * 
     * @param brand
     *     The brand
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * 
     * @return
     *     The shop
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * 
     * @param shop
     *     The shop
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    /**
     * 
     * @return
     *     The currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 
     * @param desc
     *     The desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The masterProductId
     */
    public Integer getMasterProductId() {
        return masterProductId;
    }

    /**
     * 
     * @param masterProductId
     *     The masterProductId
     */
    public void setMasterProductId(Integer masterProductId) {
        this.masterProductId = masterProductId;
    }

    /**
     * 
     * @return
     *     The hasUnits
     */
    public Boolean getHasUnits() {
        return hasUnits;
    }

    /**
     * 
     * @param hasUnits
     *     The hasUnits
     */
    public void setHasUnits(Boolean hasUnits) {
        this.hasUnits = hasUnits;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The shopLink
     */
    public String getShopLink() {
        return shopLink;
    }

    /**
     * 
     * @param shopLink
     *     The shopLink
     */
    public void setShopLink(String shopLink) {
        this.shopLink = shopLink;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The savings
     */
    public Double getSavings() {
        return savings;
    }

    /**
     * 
     * @param savings
     *     The savings
     */
    public void setSavings(Double savings) {
        this.savings = savings;
    }

    /**
     * 
     * @return
     *     The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The sale
     */
    public Boolean getSale() {
        return sale;
    }

    /**
     * 
     * @param sale
     *     The sale
     */
    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    /**
     * 
     * @return
     *     The shippingCost
     */
    public Double getShippingCost() {
        return shippingCost;
    }

    /**
     * 
     * @param shippingCost
     *     The shippingCost
     */
    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    /**
     * 
     * @return
     *     The checkoutId
     */
    public String getCheckoutId() {
        return checkoutId;
    }

    /**
     * 
     * @param checkoutId
     *     The checkoutId
     */
    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    /**
     * 
     * @return
     *     The vertical
     */
    public String getVertical() {
        return vertical;
    }

    /**
     * 
     * @param vertical
     *     The vertical
     */
    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

}
