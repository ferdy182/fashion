
package com.fernandofgallego.stylight.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Products {

    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("products")
    @Expose
    private List<Product> products = new ArrayList<Product>();
    @SerializedName("statistics")
    @Expose
    private Object statistics;
    @SerializedName("searchRequestParameters")
    @Expose
    private SearchRequestParameters searchRequestParameters;

    /**
     * 
     * @return
     *     The start
     */
    public Integer getStart() {
        return start;
    }

    /**
     * 
     * @param start
     *     The start
     */
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * 
     * @param totalResults
     *     The totalResults
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * 
     * @return
     *     The next
     */
    public String getNext() {
        return next;
    }

    /**
     * 
     * @param next
     *     The next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * 
     * @return
     *     The products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * 
     * @param products
     *     The products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * 
     * @return
     *     The statistics
     */
    public Object getStatistics() {
        return statistics;
    }

    /**
     * 
     * @param statistics
     *     The statistics
     */
    public void setStatistics(Object statistics) {
        this.statistics = statistics;
    }

    /**
     * 
     * @return
     *     The searchRequestParameters
     */
    public SearchRequestParameters getSearchRequestParameters() {
        return searchRequestParameters;
    }

    /**
     * 
     * @param searchRequestParameters
     *     The searchRequestParameters
     */
    public void setSearchRequestParameters(SearchRequestParameters searchRequestParameters) {
        this.searchRequestParameters = searchRequestParameters;
    }

}
