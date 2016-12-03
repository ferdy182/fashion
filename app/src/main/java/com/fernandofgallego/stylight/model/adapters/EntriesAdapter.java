package com.fernandofgallego.stylight.model.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fernandofgallego.stylight.R;
import com.fernandofgallego.stylight.model.entities.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class EntriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_POST = 0;
    private static final int TYPE_PRODUCT = 1;
    private static final int TYPE_HEADER = 2;


    private LayoutInflater layoutInflater;
    private Fragment host;
    private boolean horizontal;

    private List<Rendereable> items = new ArrayList<>();

    private EntriesAdapter(List<Object> items, Fragment host, boolean horizontal) {
        this.layoutInflater = LayoutInflater.from(host.getContext());
        this.host = host;
        this.horizontal = horizontal;
        this.items = processItems(items);
    }

    private List<Rendereable> processItems(List<Object> items) {
        List<Rendereable> rendereables = new ArrayList<>();
        for(Object object : items) {
            rendereables.add(RendereablePost.wrap((Post) object));
        }
        return rendereables;
    }

    public static EntriesAdapter createHorizontal(Fragment fragment, final List<Object> items) {
        return new EntriesAdapter(items, fragment, true);
    }

    public static EntriesAdapter createVertical(Fragment fragment, final List<Object> items) {
        return new EntriesAdapter(items, fragment, false);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return createHeaderViewHolder(parent);
            case TYPE_POST:
                return createPostViewHolder(parent, R.layout.card_horizontal);
            case TYPE_PRODUCT:
                return createProductViewHolder(parent, R.layout.card_vertical);
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
                bindPost((PostViewHolder) holder, (RendereablePost) items.get(position));
                break;
            case TYPE_PRODUCT:
                bindProduct((ProductViewHolder)holder, (RendereableProduct) items.get(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        final Rendereable item =  items.get(position);
        if(item instanceof RendereableProduct) {
            return TYPE_PRODUCT;
        } else if (item instanceof RendereablePost) {
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

    private void bindPost(PostViewHolder holder, RendereablePost post) {
        holder.title.setText(post.getTitle());
        holder.body.setText(post.getTitle());
        Picasso.with(holder.imageView.getContext()).load(post.getImageUrl()).into(holder.imageView);
    }

    private void bindProduct(ProductViewHolder holder, RendereableProduct product) {
        holder.textView.setText(product.getTitle());
        Picasso.with(holder.imageView.getContext()).load(product.getImageUrl()).into(holder.imageView);
    }

    // region viewholders

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageView;
        TextView textView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.info_text);
            imageView = (AppCompatImageView) itemView.findViewById(R.id.image);
        }
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageView;
        TextView title;
        TextView body;

        public PostViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.info_text);
            body = (TextView) itemView.findViewById(R.id.category_title);
            imageView = (AppCompatImageView) itemView.findViewById(R.id.image);
        }
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {

        final TextView header;
        final TextView subheader;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.card_title);
            subheader = (TextView) itemView.findViewById(R.id.card_subtitle);
        }
    }

    // endregion

    private static class ListHeader {

        private final String title;
        private final String subtitle;

        public ListHeader(String title, String subtitle) {
            this.title = title;
            this.subtitle = subtitle;
        }
    }
}
