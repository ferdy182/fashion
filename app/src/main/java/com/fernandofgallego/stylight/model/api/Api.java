package com.fernandofgallego.stylight.model.api;

import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Products;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("products")
    Call<Products> getProducts(@Query("category") int categoryId, @Query("pageItems") int pageItems);

    @GET("posts")
    Call<Posts> getPosts(@Query("category") String categoryId, @Query("pageItems") int pageItems);
}
