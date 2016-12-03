package com.fernandofgallego.stylight.model.datasource.remote;

import com.fernandofgallego.stylight.model.api.StylightClient;
import com.fernandofgallego.stylight.model.datasource.PostsDataSource;
import com.fernandofgallego.stylight.model.entities.Posts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsRemoteDataSource implements PostsDataSource {
    @Override
    public void getPosts(String categoryId, int pageItems, final LoadPostsCallback callback) {
        StylightClient.INSTANCE.getApi().getPosts(categoryId, pageItems).enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                if(response.isSuccessful())
                    callback.onPostsLoaded(response.body());
                else
                    callback.onDataNotAvailable();
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getPost(int postId, GetPostCallback callback) {
        //not implemented
    }
}
