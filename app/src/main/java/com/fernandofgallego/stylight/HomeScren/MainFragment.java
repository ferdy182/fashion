package com.fernandofgallego.stylight.HomeScren;

import android.support.v4.app.Fragment;
import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Products;

public class MainFragment extends Fragment implements MainContract.View {

    private MainContract.Presenter mainPresenter;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.start();
    }

    @Override
    public void showPosts(Posts posts) {

    }

    @Override
    public void showProducts(Products products) {

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        if(presenter != null) {
            mainPresenter = presenter;
        } else {

        }
    }
}
