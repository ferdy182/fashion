package com.fernandofgallego.stylight.model.adapters;

import com.fernandofgallego.stylight.model.entities.Product;

public class RendereableProduct implements Rendereable {

    private Product product;

    private RendereableProduct(Product product) {
        this.product = product;
    }

    public static RendereableProduct wrap(Product product) {
        return new RendereableProduct(product);
    }

    public String getTitle() {
        return product.getName();
    }

    public String getImageUrl() {
        if(product.getImages().size() > 0) {
            return product.getImages().get(0).getUrl();
        }
        return "";
    }
}
