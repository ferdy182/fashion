package com.fernandofgallego.stylight.view.main;

import android.support.v7.widget.RecyclerView;
import com.fernandofgallego.stylight.BasePresenter;
import com.fernandofgallego.stylight.BaseView;

public class MainContract {

    interface View extends BaseView<Presenter> {
        void showData(RecyclerView.Adapter adapter);
    }

    interface Presenter extends BasePresenter {
        void loadTimeline(String[] postCategories, int postPageItems, int[] productCategories, int productsPageItems);
    }
}
