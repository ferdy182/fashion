package com.fernandofgallego.stylight.view.main;

import android.support.v4.app.Fragment;
import com.fernandofgallego.stylight.Constants;
import com.fernandofgallego.stylight.model.adapters.EntriesAdapter;
import com.fernandofgallego.stylight.model.datasource.TimelineDataSource;
import com.fernandofgallego.stylight.model.datasource.TimelineRepository;
import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Products;

import java.util.Map;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    private TimelineRepository timelineRepository;

    String[] postCategories = new String[]{Constants.ID_POSTS_FASHION, Constants.ID_POSTS_LIFESTYLE};
    int[] productsCategories = new int[]{Constants.ID_PRODUCTS_CLOTHING, Constants.ID_PRODUCTS_LAMPS};

    public MainPresenter(MainContract.View view, TimelineRepository timelineRepository) {
        this.view = view;
        this.timelineRepository = timelineRepository;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {
        loadTimeline(postCategories, 3, productsCategories, 8);
    }

//    @Override
//    public void loadPosts(String category, int amount) {
//        PostsRepository.INSTANCE.getPosts(category, amount, new PostsDataSource.LoadPostsCallback() {
//            @Override
//            public void onPostsLoaded(Posts posts) {
//                EntriesAdapter adapter = EntriesAdapter.createHorizontal((Fragment) view, new ArrayList<Object>(posts.getPosts()));
////                view.showPosts(posts);
//                view.showData(adapter);
//            }
//
//            @Override
//            public void onDataNotAvailable() {
//                view.showEmptyPosts();
//            }
//        });
//    }


    @Override
    public void loadTimeline(final String[] postCategories, final int postPageItems, final int[] productCategories, final int productsPageItems) {
        TimelineRepository.INSTANCE.getTimeline(postCategories, postPageItems, productCategories, productsPageItems, new TimelineDataSource.LoadTimelineCallback() {
            @Override
            public void onDataLoaded(Map<String, Posts> postsMap, Map<Integer, Products> productsMap) {
//                EntriesAdapter adapter = EntriesAdapter.createHorizontal((Fragment) view, new ArrayList<Object>(postsMap.get(postCategories[0]).getPosts()));
//                view.showPosts(posts);
                EntriesAdapter.ListHeader[] headers = {
                        new EntriesAdapter.ListHeader("Check these out", "New and trending products"),
                        new EntriesAdapter.ListHeader("The latest fashion news", "Get up to date"),
                        new EntriesAdapter.ListHeader("The coolest lamps", "new and trending products"),
                        new EntriesAdapter.ListHeader("The latest lifestyle news", "new and trending products"),
                };
                EntriesAdapter adapter = new EntriesAdapter(productsMap, postsMap, headers, (Fragment) view);
                view.showData(adapter);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }
}
