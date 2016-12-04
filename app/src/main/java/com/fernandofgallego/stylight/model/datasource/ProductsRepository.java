package com.fernandofgallego.stylight.model.datasource;

import com.fernandofgallego.stylight.model.datasource.local.ProductsLocalDataSource;
import com.fernandofgallego.stylight.model.datasource.remote.ProductsRemoteDataSource;
import com.fernandofgallego.stylight.model.entities.Product;
import com.fernandofgallego.stylight.model.entities.Products;

public enum ProductsRepository implements ProductsDataSource {

    INSTANCE(new ProductsRemoteDataSource(), new ProductsLocalDataSource());

    private ProductsDataSource remoteProductsDataSource;
    private ProductsDataSource localProductsDataSource;

    ProductsRepository(ProductsDataSource remoteProductsDataSource, ProductsDataSource localProductsDataSource) {
        this.remoteProductsDataSource = remoteProductsDataSource;
        this.localProductsDataSource = localProductsDataSource;
    }

    @Override
    public void getProducts(final int categoryId, final int pageItems, final LoadProductsCallback callback) {
        remoteProductsDataSource.getProducts(categoryId, pageItems, new LoadProductsCallback() {
            @Override
            public void onProductsLoaded(Products Products) {
                callback.onProductsLoaded(Products);
            }

            @Override
            public void onDataNotAvailable() {
                // if remote fails, load from cache
                localProductsDataSource.getProducts(categoryId, pageItems, callback);
            }
        });
    }

    @Override
    public void getProduct(final int ProductId, final GetProductCallback callback) {
        remoteProductsDataSource.getProduct(ProductId, new GetProductCallback() {
            @Override
            public void onProductLoaded(Product Product) {
                callback.onProductLoaded(Product);
            }

            @Override
            public void onProductNotAvaialble() {
                localProductsDataSource.getProduct(ProductId, callback);
            }
        });
    }
}
