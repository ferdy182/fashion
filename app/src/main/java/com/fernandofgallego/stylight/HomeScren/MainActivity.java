package com.fernandofgallego.stylight.HomeScren;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.fernandofgallego.stylight.R;

public class MainActivity extends AppCompatActivity {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.start();

//        StylightClient.INSTANCE.getApi().getPosts(Constants.ID_POSTS_LIFESTYLE, 100).enqueue(new Callback<Posts>() {
//            @Override
//            public void onResponse(Call<Posts> call, Response<Posts> response) {
//                Posts posts = response.body();
//
//                textView.setText(String.valueOf(posts.getPosts().size()));
//            }
//
//            @Override
//            public void onFailure(Call<Posts> call, Throwable t) {
//                String error = t.getLocalizedMessage();
//                textView.setText(error);
//            }
//        });

//        StylightClient.INSTANCE.getApi().getProducts(Constants.ID_PRODUCTS_CLOTHING, 50).enqueue(new Callback<Products>() {
//            @Override
//            public void onResponse(Call<Products> call, Response<Products> response) {
//                Products products = response.body();
//                textView.setText(String.valueOf(products.getProducts().size()));
//            }
//
//            @Override
//            public void onFailure(Call<Products> call, Throwable t) {
//
//            }
//        });
    }
}
