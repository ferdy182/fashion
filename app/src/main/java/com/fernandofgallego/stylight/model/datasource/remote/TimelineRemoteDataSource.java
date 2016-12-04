package com.fernandofgallego.stylight.model.datasource.remote;

import com.fernandofgallego.stylight.model.api.StylightClient;
import com.fernandofgallego.stylight.model.datasource.TimelineDataSource;
import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Products;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TimelineRemoteDataSource implements TimelineDataSource {

    private ConcurrentHashMap<Integer, Products> productsMap;
    private ConcurrentHashMap<String, Posts> postsMap;
    private CountDownLatch latch;
    boolean error = false;

    @Override
    public void getTimeline(final String[] postCategories, final int postPageItems,
                            final int[] productCategories, final int productsPageItems ,
                            final LoadTimelineCallback callback) {

        productsMap = new ConcurrentHashMap<>(productCategories.length);
        postsMap = new ConcurrentHashMap<>(postCategories.length);
        LoadTimelineCallback timelineCallback = callback;
        latch = new CountDownLatch(postCategories.length + productCategories.length);

        Executor executor = Executors.newFixedThreadPool(4);
        executor.execute(new PostRequestRunnable(postCategories, postPageItems, timelineCallback));
        executor.execute(new ProductsRequestRunnable(productCategories, productsPageItems, timelineCallback));

        try {
            latch.await();  // wait until latch counted down to 0
        } catch (InterruptedException e) {
            timelineCallback.onDataNotAvailable();
            return;
        }

        if(error) {
            timelineCallback.onDataNotAvailable();
        } else {
            timelineCallback.onDataLoaded(postsMap, productsMap);
        }

    }

    private synchronized void onError() {
        error = true;
    }

    private class PostRequestRunnable implements Runnable {

        String[] postCategories;
        int postItemsPage;
        private LoadTimelineCallback timelineCallback;

        PostRequestRunnable(String[] postCategories, int postItemsPage, LoadTimelineCallback timelineCallback) {
            this.postCategories = postCategories;
            this.postItemsPage = postItemsPage;
            this.timelineCallback = timelineCallback;
        }

        @Override
        public void run() {
            for (final String category : postCategories) {
                Response<Posts> items;
                try {
                    items = StylightClient.INSTANCE.getApi().getPosts(category, postItemsPage).execute();
                    if (items != null) {
                        postsMap.put(category, items.body());
                    } else {
                        onError();
                    }
                } catch (IOException e) {
                    onError();
                }
                latch.countDown();
            }
        }
    }

    private class ProductsRequestRunnable implements Runnable {

        int[] productCategories;
        int productItemsPage;
        private LoadTimelineCallback timelineCallback;

        ProductsRequestRunnable(int[] productCategories, int productItemsPage, LoadTimelineCallback timelineCallback) {
            this.productCategories = productCategories;
            this.productItemsPage = productItemsPage;
            this.timelineCallback = timelineCallback;
        }

        @Override
        public void run() {
            for (final int category : productCategories) {
                Response<Products> items;
                try {
                    items = StylightClient.INSTANCE.getApi().getProducts(category, productItemsPage).execute();
                    if (items != null) {
                        productsMap.put(category, items.body());
                    } else {
                        onError();
                    }
                } catch (IOException e) {
                    onError();
                }
                latch.countDown();
            }
        }
    }
}
