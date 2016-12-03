
package com.fernandofgallego.stylight.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Post {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("teaserImage")
    @Expose
    private String teaserImage;
    @SerializedName("teaserImageHorizontal")
    @Expose
    private String teaserImageHorizontal;
    @SerializedName("teaserImageDarkBackground")
    @Expose
    private Boolean teaserImageDarkBackground;
    @SerializedName("datemodified")
    @Expose
    private String datemodified;
    @SerializedName("datecreated")
    @Expose
    private String datecreated;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("sponsor")
    @Expose
    private Object sponsor;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("flexibleContent")
    @Expose
    private List<Object> flexibleContent = new ArrayList<Object>();
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = new ArrayList<Tag>();
    @SerializedName("hasVideo")
    @Expose
    private Boolean hasVideo;
    @SerializedName("hasProducts")
    @Expose
    private Boolean hasProducts;
    @SerializedName("products")
    @Expose
    private List<Product> products = new ArrayList<Product>();
    @SerializedName("itemsHeadline")
    @Expose
    private String itemsHeadline;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("images")
    @Expose
    private List<Image_> images = new ArrayList<Image_>();
    @SerializedName("items")
    @Expose
    private List<Object> items = new ArrayList<Object>();

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
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * 
     * @param slug
     *     The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     * 
     * @return
     *     The teaserImage
     */
    public String getTeaserImage() {
        return teaserImage;
    }

    /**
     * 
     * @param teaserImage
     *     The teaserImage
     */
    public void setTeaserImage(String teaserImage) {
        this.teaserImage = teaserImage;
    }

    /**
     * 
     * @return
     *     The teaserImageHorizontal
     */
    public String getTeaserImageHorizontal() {
        return teaserImageHorizontal;
    }

    /**
     * 
     * @param teaserImageHorizontal
     *     The teaserImageHorizontal
     */
    public void setTeaserImageHorizontal(String teaserImageHorizontal) {
        this.teaserImageHorizontal = teaserImageHorizontal;
    }

    /**
     * 
     * @return
     *     The teaserImageDarkBackground
     */
    public Boolean getTeaserImageDarkBackground() {
        return teaserImageDarkBackground;
    }

    /**
     * 
     * @param teaserImageDarkBackground
     *     The teaserImageDarkBackground
     */
    public void setTeaserImageDarkBackground(Boolean teaserImageDarkBackground) {
        this.teaserImageDarkBackground = teaserImageDarkBackground;
    }

    /**
     * 
     * @return
     *     The datemodified
     */
    public String getDatemodified() {
        return datemodified;
    }

    /**
     * 
     * @param datemodified
     *     The datemodified
     */
    public void setDatemodified(String datemodified) {
        this.datemodified = datemodified;
    }

    /**
     * 
     * @return
     *     The datecreated
     */
    public String getDatecreated() {
        return datecreated;
    }

    /**
     * 
     * @param datecreated
     *     The datecreated
     */
    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    /**
     * 
     * @return
     *     The category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * 
     * @return
     *     The sponsor
     */
    public Object getSponsor() {
        return sponsor;
    }

    /**
     * 
     * @param sponsor
     *     The sponsor
     */
    public void setSponsor(Object sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * 
     * @return
     *     The author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * 
     * @param author
     *     The author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * 
     * @return
     *     The flexibleContent
     */
    public List<Object> getFlexibleContent() {
        return flexibleContent;
    }

    /**
     * 
     * @param flexibleContent
     *     The flexibleContent
     */
    public void setFlexibleContent(List<Object> flexibleContent) {
        this.flexibleContent = flexibleContent;
    }

    /**
     * 
     * @return
     *     The tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The hasVideo
     */
    public Boolean getHasVideo() {
        return hasVideo;
    }

    /**
     * 
     * @param hasVideo
     *     The hasVideo
     */
    public void setHasVideo(Boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    /**
     * 
     * @return
     *     The hasProducts
     */
    public Boolean getHasProducts() {
        return hasProducts;
    }

    /**
     * 
     * @param hasProducts
     *     The hasProducts
     */
    public void setHasProducts(Boolean hasProducts) {
        this.hasProducts = hasProducts;
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
     *     The itemsHeadline
     */
    public String getItemsHeadline() {
        return itemsHeadline;
    }

    /**
     * 
     * @param itemsHeadline
     *     The itemsHeadline
     */
    public void setItemsHeadline(String itemsHeadline) {
        this.itemsHeadline = itemsHeadline;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The body
     */
    public String getBody() {
        return body;
    }

    /**
     * 
     * @param body
     *     The body
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 
     * @return
     *     The images
     */
    public List<Image_> getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(List<Image_> images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The items
     */
    public List<Object> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    public void setItems(List<Object> items) {
        this.items = items;
    }

}
