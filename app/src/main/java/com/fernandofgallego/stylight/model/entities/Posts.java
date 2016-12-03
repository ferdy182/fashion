
package com.fernandofgallego.stylight.model.entities;

import com.fernandofgallego.stylight.model.adapters.Rendereable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class Posts implements Rendereable {

    @SerializedName("posts")
    @Expose
    private List<Post> posts = new ArrayList<Post>();
    @SerializedName("featuredPosts")
    @Expose
    private List<Object> featuredPosts = new ArrayList<Object>();
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("next")
    @Expose
    private String next;

    /**
     * 
     * @return
     *     The posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * 
     * @param posts
     *     The posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * 
     * @return
     *     The featuredPosts
     */
    public List<Object> getFeaturedPosts() {
        return featuredPosts;
    }

    /**
     * 
     * @param featuredPosts
     *     The featuredPosts
     */
    public void setFeaturedPosts(List<Object> featuredPosts) {
        this.featuredPosts = featuredPosts;
    }

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
     *     The totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 
     * @param totalCount
     *     The totalCount
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
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

}
