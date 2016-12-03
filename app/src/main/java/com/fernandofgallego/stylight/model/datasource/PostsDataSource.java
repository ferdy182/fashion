package com.fernandofgallego.stylight.model.datasource;

import com.fernandofgallego.stylight.model.entities.Post;
import com.fernandofgallego.stylight.model.entities.Posts;

public interface PostsDataSource {

    interface LoadPostsCallback {
        void onPostsLoaded(Posts posts);
        void onDataNotAvailable();
    }

    interface GetPostCallback {
        void onPostLoaded(Post post);
        void onPostNotAvaialble();
    }

    void getPosts(String categoryId, int pageItems, LoadPostsCallback callback);
    void getPost(int postId, GetPostCallback callback);
}
