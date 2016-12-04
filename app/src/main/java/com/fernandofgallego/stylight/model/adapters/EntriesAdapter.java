package com.fernandofgallego.stylight.model.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fernandofgallego.stylight.Constants;
import com.fernandofgallego.stylight.R;
import com.fernandofgallego.stylight.model.entities.Post;
import com.fernandofgallego.stylight.model.entities.Posts;
import com.fernandofgallego.stylight.model.entities.Product;
import com.fernandofgallego.stylight.model.entities.Products;
import com.squareup.picasso.Picasso;

import java.util.*;

public class EntriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_POST = 0;
    private static final int TYPE_PRODUCT = 1;
    private static final int TYPE_HEADER = 2;


    private LayoutInflater layoutInflater;

    private ListHeader[] headers;
    private Map<Integer, Products> productsMap;
    private Map<String, Posts> postsMap;

    private List<Object> items;

    public EntriesAdapter(Map<Integer, Products> productsMap,
                          Map<String, Posts> postsMap,
                          ListHeader[] headers,
                          Fragment host) {
        this.layoutInflater = LayoutInflater.from(host.getContext());
        this.productsMap = productsMap;
        this.postsMap = postsMap;
        this.headers = headers;
        this.productsMap = productsMap;
        this.postsMap = postsMap;

        items = new ArrayList<>();
        addItem(items, headers[0], productsMap.get(Constants.ID_PRODUCTS_CLOTHING));
        addItems(items, headers[1], postsMap.get(Constants.ID_POSTS_FASHION).getPosts());
        addItem(items, headers[2], productsMap.get(Constants.ID_PRODUCTS_LAMPS));
        addItems(items, headers[3], postsMap.get(Constants.ID_POSTS_LIFESTYLE).getPosts());
    }

    private void addItem(List<Object> items, ListHeader header, Products item) {
        if (item != null && item.getProducts().size() > 0) {
            items.add(header);
            items.add(item);
        }
    }

    private void addItems(List<Object> items, ListHeader header, Collection entries) {
        if (entries != null && entries.size() > 0) {
            items.add(header);
            items.addAll(entries);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return createHeaderViewHolder(parent);
            case TYPE_POST:
                return createPostViewHolder(parent, R.layout.card_horizontal);
            case TYPE_PRODUCT:
                return createProductViewHolder(parent, R.layout.row_products);
            default:
                throw new IllegalArgumentException("Unknown view type");
        }

    }

    private ProductViewHolder createProductViewHolder(ViewGroup parent, int layout) {
        return new ProductViewHolder(layoutInflater.inflate(layout, parent, false));
    }

    private PostViewHolder createPostViewHolder(ViewGroup parent, int layout) {
        return new PostViewHolder(layoutInflater.inflate(layout, parent, false));
    }

    private HeaderViewHolder createHeaderViewHolder(ViewGroup parent) {
        return new HeaderViewHolder(layoutInflater.inflate(R.layout.list_header, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                bindHeader((HeaderViewHolder)holder, (ListHeader) items.get(position));
                break;
            case TYPE_POST:
                bindPost((PostViewHolder) holder, (Post) items.get(position));
                break;
            case TYPE_PRODUCT:
                bindProduct((ProductViewHolder)holder, (Products) items.get(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        final Object item =  items.get(position);
        if(item instanceof Products) {
            return TYPE_PRODUCT;
        } else if (item instanceof Post) {
            return TYPE_POST;
        } else if (item instanceof ListHeader) {
            return TYPE_HEADER;
        }
        throw new IllegalArgumentException("Unknown view type");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void bindHeader(HeaderViewHolder holder, ListHeader header) {
        holder.header.setText(header.title);
        holder.subheader.setText(header.subtitle);
    }

    private void bindPost(PostViewHolder holder, Post post) {
        holder.title.setText(post.getTitle());
        holder.body.setText(post.getTitle());
        Picasso.with(holder.imageView.getContext()).load(post.getTeaserImage()).into(holder.imageView);
    }

    private void bindProduct(ProductViewHolder holder, Products products) {
        PagerAdapter pagerAdapter = new ProductsPagerAdapter(products);
        holder.pager.setAdapter(pagerAdapter);
    }

    private static class ProductsPagerAdapter extends PagerAdapter {
        Products products;

        ProductsPagerAdapter(Products products) {
            this.products = products;
        }

        @Override
        public float getPageWidth(int position) {
            return 0.45f;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(container.getContext()).inflate(R.layout.card_vertical, container, false);

            Product product = products.getProducts().get(position);

            TextView textView = (TextView) view.findViewById(R.id.info_text);
            TextView priceView = (TextView) view.findViewById(R.id.price_text);
            textView.setText(product.getName());
            priceView.setText(String.format(Locale.GERMAN,"%.02f %s",
                    product.getPrice(), product.getCurrency().getSymbol()));

            AppCompatImageView imageView = (AppCompatImageView) view.findViewById(R.id.product_image);

            try {
                String imageUrl = product.getImages().get(0).getUrl();
                Picasso.with(container.getContext())
                        .load(imageUrl)
                        .into(imageView);
            } catch (Exception e) {
                // no image for this product
            }

            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);

        }

        @Override
        public int getCount() {
            return products.getProducts().size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }
    }

    // region viewholders


    private static class ProductViewHolder extends RecyclerView.ViewHolder {
        ViewPager pager;

        ProductViewHolder(View itemView) {
            super(itemView);
            pager = (ViewPager) itemView.findViewById(R.id.pager);
        }
    }

    private static class PostViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageView;
        TextView title;
        TextView body;

        PostViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.info_text);
            body = (TextView) itemView.findViewById(R.id.category_title);
            imageView = (AppCompatImageView) itemView.findViewById(R.id.image);
        }
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {

        final TextView header;
        final TextView subheader;

        HeaderViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.card_title);
            subheader = (TextView) itemView.findViewById(R.id.card_subtitle);
        }
    }

    public static class ListHeader {
        final String title;
        final String subtitle;

        public ListHeader(String title, String subtitle) {
            this.title = title;
            this.subtitle = subtitle;
        }
    }

    // endregion

}
