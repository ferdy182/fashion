package com.fernandofgallego.stylight.model.adapters;

import com.fernandofgallego.stylight.model.entities.Post;

public class RendereablePost implements Rendereable {
    private Post post;

    private RendereablePost(Post post) {
        this.post = post;
    }

    public static RendereablePost wrap(Post post) {
        return new RendereablePost(post);
    }

    public String getTitle() {
        return post.getTitle();
    }

    public String getImageUrl() {
        return post.getTeaserImage();
    }

    public String getCategoryTitle() {
        return post.getCategory().getName();
    }
}
