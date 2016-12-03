package com.fernandofgallego.stylight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.fernandofgallego.stylight.model.Constants;
import com.fernandofgallego.stylight.model.api.StylightClient;
import com.fernandofgallego.stylight.model.entities.Posts;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.mytext);

        StylightClient.INSTANCE.getApi().getPosts(Constants.ID_POSTS_FASHION, 8).enqueue(new Callback<Posts>() {
            @Override
            public void onResponse(Call<Posts> call, Response<Posts> response) {
                Posts posts = response.body();

                textView.setText(String.valueOf(posts.getPosts().size()));
            }

            @Override
            public void onFailure(Call<Posts> call, Throwable t) {
                String error = t.getLocalizedMessage();
                textView.setText(error);
            }
        });
    }
}
