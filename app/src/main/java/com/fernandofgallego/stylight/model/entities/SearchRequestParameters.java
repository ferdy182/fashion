
package com.fernandofgallego.stylight.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class SearchRequestParameters {

    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("colors")
    @Expose
    private List<Object> colors = new ArrayList<Object>();
    @SerializedName("styles")
    @Expose
    private List<Object> styles = new ArrayList<Object>();
    @SerializedName("patterns")
    @Expose
    private List<Object> patterns = new ArrayList<Object>();
    @SerializedName("brands")
    @Expose
    private List<Object> brands = new ArrayList<Object>();
    @SerializedName("shops")
    @Expose
    private List<Object> shops = new ArrayList<Object>();
    @SerializedName("materials")
    @Expose
    private List<Object> materials = new ArrayList<Object>();
    @SerializedName("occasions")
    @Expose
    private List<Object> occasions = new ArrayList<Object>();
    @SerializedName("rooms")
    @Expose
    private List<Object> rooms = new ArrayList<Object>();
    @SerializedName("minPrice")
    @Expose
    private Object minPrice;
    @SerializedName("maxPrice")
    @Expose
    private Object maxPrice;
    @SerializedName("sale")
    @Expose
    private Boolean sale;
    @SerializedName("freeShipping")
    @Expose
    private Boolean freeShipping;
    @SerializedName("searchString")
    @Expose
    private Object searchString;
    @SerializedName("sortBy")
    @Expose
    private String sortBy;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("verticals")
    @Expose
    private List<String> verticals = new ArrayList<String>();

    /**
     * 
     * @return
     *     The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The colors
     */
    public List<Object> getColors() {
        return colors;
    }

    /**
     * 
     * @param colors
     *     The colors
     */
    public void setColors(List<Object> colors) {
        this.colors = colors;
    }

    /**
     * 
     * @return
     *     The styles
     */
    public List<Object> getStyles() {
        return styles;
    }

    /**
     * 
     * @param styles
     *     The styles
     */
    public void setStyles(List<Object> styles) {
        this.styles = styles;
    }

    /**
     * 
     * @return
     *     The patterns
     */
    public List<Object> getPatterns() {
        return patterns;
    }

    /**
     * 
     * @param patterns
     *     The patterns
     */
    public void setPatterns(List<Object> patterns) {
        this.patterns = patterns;
    }

    /**
     * 
     * @return
     *     The brands
     */
    public List<Object> getBrands() {
        return brands;
    }

    /**
     * 
     * @param brands
     *     The brands
     */
    public void setBrands(List<Object> brands) {
        this.brands = brands;
    }

    /**
     * 
     * @return
     *     The shops
     */
    public List<Object> getShops() {
        return shops;
    }

    /**
     * 
     * @param shops
     *     The shops
     */
    public void setShops(List<Object> shops) {
        this.shops = shops;
    }

    /**
     * 
     * @return
     *     The materials
     */
    public List<Object> getMaterials() {
        return materials;
    }

    /**
     * 
     * @param materials
     *     The materials
     */
    public void setMaterials(List<Object> materials) {
        this.materials = materials;
    }

    /**
     * 
     * @return
     *     The occasions
     */
    public List<Object> getOccasions() {
        return occasions;
    }

    /**
     * 
     * @param occasions
     *     The occasions
     */
    public void setOccasions(List<Object> occasions) {
        this.occasions = occasions;
    }

    /**
     * 
     * @return
     *     The rooms
     */
    public List<Object> getRooms() {
        return rooms;
    }

    /**
     * 
     * @param rooms
     *     The rooms
     */
    public void setRooms(List<Object> rooms) {
        this.rooms = rooms;
    }

    /**
     * 
     * @return
     *     The minPrice
     */
    public Object getMinPrice() {
        return minPrice;
    }

    /**
     * 
     * @param minPrice
     *     The minPrice
     */
    public void setMinPrice(Object minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * 
     * @return
     *     The maxPrice
     */
    public Object getMaxPrice() {
        return maxPrice;
    }

    /**
     * 
     * @param maxPrice
     *     The maxPrice
     */
    public void setMaxPrice(Object maxPrice) {
        this.maxPrice = maxPrice;
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
     *     The freeShipping
     */
    public Boolean getFreeShipping() {
        return freeShipping;
    }

    /**
     * 
     * @param freeShipping
     *     The freeShipping
     */
    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    /**
     * 
     * @return
     *     The searchString
     */
    public Object getSearchString() {
        return searchString;
    }

    /**
     * 
     * @param searchString
     *     The searchString
     */
    public void setSearchString(Object searchString) {
        this.searchString = searchString;
    }

    /**
     * 
     * @return
     *     The sortBy
     */
    public String getSortBy() {
        return sortBy;
    }

    /**
     * 
     * @param sortBy
     *     The sortBy
     */
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public Object getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(Object gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The verticals
     */
    public List<String> getVerticals() {
        return verticals;
    }

    /**
     * 
     * @param verticals
     *     The verticals
     */
    public void setVerticals(List<String> verticals) {
        this.verticals = verticals;
    }

}
