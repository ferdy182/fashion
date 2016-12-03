package com.fernandofgallego.stylight.view.main;

import android.support.v4.app.Fragment;
import com.fernandofgallego.stylight.Constants;
import com.fernandofgallego.stylight.model.adapters.EntriesAdapter;
import com.fernandofgallego.stylight.model.datasource.PostsDataSource;
import com.fernandofgallego.stylight.model.datasource.PostsRepository;
import com.fernandofgallego.stylight.model.datasource.ProductsDataSource;
import com.fernandofgallego.stylight.model.datasource.ProductsRepository;
import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Products;

import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    private PostsRepository postsRepository;

    public MainPresenter(MainContract.View view, PostsRepository postsRepository) {
        this.view = view;
        this.postsRepository = postsRepository;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {
        loadPosts(Constants.ID_POSTS_FASHION, 8);
    }

    @Override
    public void loadProducts(int category, int amount) {
        ProductsRepository.INSTANCE.getProducts(category, amount, new ProductsDataSource.LoadProductsCallback() {
            @Override
            public void onProductsLoaded(Products Products) {

            }

            @Override
            public void onDataNotAvailable() {

            }
        });

    }

    @Override
    public void loadPosts(String category, int amount) {
        PostsRepository.INSTANCE.getPosts(category, amount, new PostsDataSource.LoadPostsCallback() {
            @Override
            public void onPostsLoaded(Posts posts) {
                EntriesAdapter adapter = EntriesAdapter.createHorizontal((Fragment) view, new ArrayList<Object>(posts.getPosts()));
//                view.showPosts(posts);
                view.showData(adapter);
            }

            @Override
            public void onDataNotAvailable() {
                view.showEmptyPosts();
            }
        });
    }



}
