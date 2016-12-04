package com.fernandofgallego.stylight.model.datasource;

import com.fernandofgallego.stylight.model.datasource.local.TimelineLocalDataSource;
import com.fernandofgallego.stylight.model.datasource.remote.TimelineRemoteDataSource;
import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Products;

import java.util.Map;

public enum TimelineRepository implements TimelineDataSource {

    INSTANCE(new TimelineRemoteDataSource(), new TimelineLocalDataSource());

    private TimelineDataSource remoteTimelineDataSource;
    private TimelineDataSource localTimelineDataSource;

    TimelineRepository(TimelineDataSource remoteTimelineDataSource, TimelineDataSource localTimelineDataSource) {
        this.remoteTimelineDataSource = remoteTimelineDataSource;
        this.localTimelineDataSource = localTimelineDataSource;
    }

    @Override
    public void getTimeline(final String[] postCategories, final int postPageItems, final int[] productCategories, final int productsPageItems, final LoadTimelineCallback callback) {
        remoteTimelineDataSource.getTimeline(postCategories, postPageItems, productCategories, productsPageItems, new LoadTimelineCallback() {
            @Override
            public void onDataLoaded(Map<String, Posts> postsMap, Map<Integer, Products> productsMap) {
                callback.onDataLoaded(postsMap, productsMap);
            }

            @Override
            public void onDataNotAvailable() {
                localTimelineDataSource.getTimeline(postCategories, postPageItems, productCategories, productsPageItems, callback);
            }
        });
    }
}
