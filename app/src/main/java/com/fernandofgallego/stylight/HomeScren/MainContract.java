package com.fernandofgallego.stylight.HomeScren;

import com.fernandofgallego.stylight.BasePresenter;
import com.fernandofgallego.stylight.BaseView;
import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Products;

public class MainContract {

    interface View extends BaseView<Presenter> {
        void showPosts(Posts posts);
        void showProducts(Products products);
    }

    interface Presenter extends BasePresenter {
        void loadProducts(int category, int amount);
        void loadPosts(String category, int amount);
    }
}
