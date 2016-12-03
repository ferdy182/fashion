package com.fernandofgallego.stylight.model.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fernandofgallego.stylight.R;
import com.fernandofgallego.stylight.model.entities.Products;
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

    private EntriesAdapter(List<Rendereable> items, Fragment host, boolean horizontal) {
        this.layoutInflater = LayoutInflater.from(host.getContext());
        this.host = host;
        this.horizontal = horizontal;
        this.items = processItems(items);
    }

    private List<Rendereable> processItems(List<Rendereable> items) {
        return items;
    }

    public static EntriesAdapter createHorizontal(Fragment fragment, final List<Rendereable> items) {
        return new EntriesAdapter(items, fragment, true);
    }

    public static EntriesAdapter createVertical(Fragment fragment, final List<Rendereable> items) {
        return new EntriesAdapter(items, fragment, false);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return createHeaderViewHolder(parent);
            case TYPE_POST:
                return createCadViewHolder(parent, R.layout.card_horizontal);
            case TYPE_PRODUCT:
                return createCadViewHolder(parent, R.layout.card_vertical);
            default:
                throw new IllegalArgumentException("Unknown view type");
        }

    }

    private EntryViewHolder createCadViewHolder(ViewGroup parent, int layout) {
        return new EntryViewHolder(layoutInflater.inflate(layout, parent, false));
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
                bindEntry((EntryViewHolder)holder, items.get(position));
                break;
            case TYPE_PRODUCT:
                bindEntry((EntryViewHolder)holder, items.get(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        final Rendereable item =  items.get(position);
        if(item instanceof Products) {
            return TYPE_PRODUCT;
        } else if (item instanceof Rendereable) {
            return TYPE_POST;
        } else if (item instanceof Rendereable) {
            return TYPE_HEADER;
        }
        throw new IllegalArgumentException("Unkown view type");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void bindHeader(HeaderViewHolder holder, ListHeader header) {
        holder.header.setText(header.title);
        holder.subheader.setText(header.subtitle);
    }

    private void bindEntry(EntryViewHolder holder, Rendereable post) {
        holder.textView.setText(post.getTitle());
        Picasso.with(holder.imageView.getContext()).load(post.getImageUrl()).into(holder.imageView);
    }

    // region viewholders

    public static class EntryViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageView;
        TextView textView;

        public EntryViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.info_text);
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
