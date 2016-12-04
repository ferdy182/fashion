package com.fernandofgallego.stylight.view.main;

import android.support.v7.widget.RecyclerView;
import com.fernandofgallego.stylight.BasePresenter;
import com.fernandofgallego.stylight.BaseView;
import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Products;

public class MainContract {

    interface View extends BaseView<Presenter> {
        void showPosts(Posts posts);
        void showProducts(Products products);
        void showEmptyPosts();
        void showEmptyProducts();
        void showData(RecyclerView.Adapter adapter);
    }

    interface Presenter extends BasePresenter {
        void loadTimeline(String[] postCategories, int postPageItems, int[] productCategories, int productsPageItems);
    }
}
