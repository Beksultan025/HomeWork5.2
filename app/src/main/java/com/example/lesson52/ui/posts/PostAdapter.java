package com.example.lesson52.ui.posts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson52.Click;
import com.example.lesson52.data.models.Post;
import com.example.lesson52.databinding.ItemPostBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> posts = new ArrayList<>();
    private Click click;
    HashMap<Integer, String> hashMap = new HashMap<>();

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    public void setClick(Click click) {
        this.click = click;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding = ItemPostBinding.inflate(
                LayoutInflater.from(parent.getContext())
                , parent
                , false
        );

        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.onBind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    protected class PostViewHolder extends RecyclerView.ViewHolder {

        private ItemPostBinding binding;

        public PostViewHolder(@NonNull ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void onBind(Post post) {
            setHash();
            binding.tvUserId.setText(hashMap.get(post.getUserId()));
            binding.tvTitle.setText(post.getTitle());
            binding.tvContent.setText(post.getContent());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    click.click(post);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    click.longClick(post);
                    return true;
                }
            });
        }
        private void setHash() {
            hashMap.put(1,"Ислам");
            hashMap.put(2,"Нурель");
            hashMap.put(3,"Матай");
            hashMap.put(4,"Марат");
            hashMap.put(5,"Санжар");
            hashMap.put(6,"Элмурод");
            hashMap.put(7,"Арстанбек");
            hashMap.put(8,"Дастан");
            hashMap.put(9,"Бексултан");
            hashMap.put(10,"Рустам");
        }
    }
}
