package com.fernandofgallego.stylight.model.datasource.remote;

import com.fernandofgallego.stylight.Constants;
import com.fernandofgallego.stylight.model.datasource.TimelineDataSource;
import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Products;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static junit.framework.Assert.*;


public class TimelineRemoteDataSourceTest {

    private static final int itemsPage = 8;

    private Map<String, Posts> postsMap;
    private Map<Integer, Products> productsMap;

    @Test
    public void getTimeline() throws Exception {
        TimelineRemoteDataSource timelineRemoteDataSource = new TimelineRemoteDataSource();
        String[] postCategories = new String[]{Constants.ID_POSTS_FASHION, Constants.ID_POSTS_LIFESTYLE};
        int[] productsCategories = new int[]{Constants.ID_PRODUCTS_CLOTHING, Constants.ID_PRODUCTS_LAMPS};

        final Lock lock = new ReentrantLock();

        timelineRemoteDataSource.getTimeline(postCategories, itemsPage, productsCategories, itemsPage, new TimelineDataSource.LoadTimelineCallback() {
            @Override
            public void onDataLoaded(Map<String, Posts> posts, Map<Integer, Products> products) {
                postsMap = posts;
                productsMap = products;
                synchronized (lock) {
                    lock.notifyAll();
                }
            }

            @Override
            public void onDataNotAvailable() {
                synchronized (lock) {
                    lock.notifyAll();
                }
            }
        });

        synchronized (lock) {
            lock.wait(3000);

            assertFalse(postsMap.isEmpty());
            assertNotNull(postsMap.get(postCategories[0]));
            assertNotNull(postsMap.get(postCategories[1]));

            assertFalse(productsMap.isEmpty());
            assertNotNull(productsMap.get(productsCategories[0]));
            assertNotNull(productsMap.get(productsCategories[1]));

        }
    }

}