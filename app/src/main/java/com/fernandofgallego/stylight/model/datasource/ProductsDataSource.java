package com.fernandofgallego.stylight.model.datasource;

import com.fernandofgallego.stylight.model.entities.Product;
import com.fernandofgallego.stylight.model.entities.Products;

public interface ProductsDataSource {

    interface LoadProductsCallback {
        void onProductsLoaded(Products Products);
        void onDataNotAvailable();
    }

    interface GetProductCallback {
        void onProductLoaded(Product Product);
        void onProductNotAvaialble();
    }

    void getProducts(int categoryId, int pageItems, LoadProductsCallback callback);
    void getProduct(int ProductId, GetProductCallback callback);
}
