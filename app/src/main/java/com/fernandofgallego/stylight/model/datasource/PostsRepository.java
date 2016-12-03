package com.fernandofgallego.stylight.model.datasource;

import com.fernandofgallego.stylight.model.datasource.local.PostsLocalDataSource;
import com.fernandofgallego.stylight.model.datasource.remote.PostsRemoteDataSource;
import com.fernandofgallego.stylight.model.entities.Post;
import com.fernandofgallego.stylight.model.entities.Posts;

public enum PostsRepository implements PostsDataSource {

    INSTANCE(new PostsRemoteDataSource(), new PostsLocalDataSource());

    private PostsDataSource remotePostsDataSource;
    private PostsDataSource localPostsDataSource;

    private PostsRepository(PostsDataSource remotePostsDataSource, PostsDataSource localPostsDataSource) {
        this.remotePostsDataSource = remotePostsDataSource;
        this.localPostsDataSource = localPostsDataSource;
    }

//    public static PostsRepository getInstance(PostsDataSource remotePostsDataSource,
//                                              PostsDataSource localPostsDataSource) {
//
//        return INSTANCE;
//    }

    @Override
    public void getPosts(final String categoryId, final int pageItems, final LoadPostsCallback callback) {
        remotePostsDataSource.getPosts(categoryId, pageItems, new LoadPostsCallback() {
            @Override
            public void onPostsLoaded(Posts posts) {
                callback.onPostsLoaded(posts);
            }

            @Override
            public void onDataNotAvailable() {
                // if remote fails, load from cache
                localPostsDataSource.getPosts(categoryId, pageItems, callback);
            }
        });
    }

    @Override
    public void getPost(final int postId, final GetPostCallback callback) {
        remotePostsDataSource.getPost(postId, new GetPostCallback() {
            @Override
            public void onPostLoaded(Post post) {
                callback.onPostLoaded(post);
            }

            @Override
            public void onPostNotAvaialble() {
                localPostsDataSource.getPost(postId, callback);
            }
        });
    }
}
