
package com.fernandofgallego.stylight.model.entities;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Shop {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("premium")
    @Expose
    private Boolean premium;
    @SerializedName("site")
    @Expose
    private Site site;
    @SerializedName("logo")
    @Expose
    private String logo;

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
     *     The premium
     */
    public Boolean getPremium() {
        return premium;
    }

    /**
     * 
     * @param premium
     *     The premium
     */
    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    /**
     * 
     * @return
     *     The site
     */
    public Site getSite() {
        return site;
    }

    /**
     * 
     * @param site
     *     The site
     */
    public void setSite(Site site) {
        this.site = site;
    }

    /**
     * 
     * @return
     *     The logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 
     * @param logo
     *     The logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

}
