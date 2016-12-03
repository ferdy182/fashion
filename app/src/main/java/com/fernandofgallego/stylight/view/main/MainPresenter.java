package com.fernandofgallego.stylight.view.main;

import android.support.v4.app.Fragment;
import com.fernandofgallego.stylight.Constants;
import com.fernandofgallego.stylight.model.adapters.EntriesAdapter;
import com.fernandofgallego.stylight.model.adapters.Rendereable;
import com.fernandofgallego.stylight.model.datasource.PostsDataSource;
import com.fernandofgallego.stylight.model.datasource.PostsRepository;
import com.fernandofgallego.stylight.model.entities.Posts;

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

    }

    @Override
    public void loadPosts(String category, int amount) {
        PostsRepository.INSTANCE.getPosts(category, amount, new PostsDataSource.LoadPostsCallback() {
            @Override
            public void onPostsLoaded(Posts posts) {
                EntriesAdapter adapter = EntriesAdapter.createHorizontal((Fragment) view, new ArrayList<Rendereable>(posts.getPosts()));
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
