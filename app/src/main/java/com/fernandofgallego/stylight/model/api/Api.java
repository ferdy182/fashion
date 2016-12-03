package com.fernandofgallego.stylight.model.api;

import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Products;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface Api {

    @GET("products")
    Call<List<Products>> getProducts(@Query("category") int categoryId, @Query("pageItems") int pageItems);

    @GET("posts")
    Call<List<Posts>> getPosts(@Query("category") String categoryId, @Query("pageItems") int pageItems);
}
