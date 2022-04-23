package com.example.lesson52;

import com.example.lesson52.data.models.Post;

public interface Click {
    void click(Post post);

    void longClick(Post post);
}
