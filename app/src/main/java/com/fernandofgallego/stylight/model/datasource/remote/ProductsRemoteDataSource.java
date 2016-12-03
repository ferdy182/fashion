package com.fernandofgallego.stylight.model.datasource.remote;

import com.fernandofgallego.stylight.model.api.StylightClient;
import com.fernandofgallego.stylight.model.datasource.ProductsDataSource;
import com.fernandofgallego.stylight.model.entities.Products;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsRemoteDataSource implements ProductsDataSource {
    @Override
    public void getProducts(int categoryId, int pageItems, final LoadProductsCallback callback) {
        StylightClient.INSTANCE.getApi().getProducts(categoryId, pageItems).enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                if(response.isSuccessful())
                    callback.onProductsLoaded(response.body());
                else
                    callback.onDataNotAvailable();
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getProduct(int ProductId, GetProductCallback callback) {
        //not implemented
    }
}
