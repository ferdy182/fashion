package com.fernandofgallego.stylight.model.datasource;

import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Products;

import java.util.Map;

public interface TimelineDataSource {
    interface LoadTimelineCallback {
        void onDataLoaded(Map<String, Posts> postsMap, Map<Integer, Products> productsMap);
        void onDataNotAvailable();
    }

    void getTimeline(String[] postCategories, int postPageItems, int[] productCategories, int productsPageItems,
                     TimelineDataSource.LoadTimelineCallback callback);
}
