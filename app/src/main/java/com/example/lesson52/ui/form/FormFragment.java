package com.example.lesson52.ui.form;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson52.R;
import com.example.lesson52.data.App;
import com.example.lesson52.data.models.Post;
import com.example.lesson52.databinding.FragmentFormBinding;
import com.example.lesson52.ui.posts.PostAdapter;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormFragment extends Fragment {

    private Post post;
    private static final int GROUP_ID = 41;
    private static final int USER_ID = 1;
    private FragmentFormBinding binding;

    public FormFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
        getBundle();
    }

    private void getBundle() {
        Bundle bundle = getArguments();
        if (getArguments() != null) {
            post = (Post) bundle.getSerializable("key");
            binding.etContent.setText(post.getContent());
            binding.etTitle.setText(post.getTitle());
        }
    }

    private void initListener() {
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getArguments() != null) {
                    updatePost();
                } else {
                    createPost();
                }
            }
        });
    }

    private void createPost() {
        post = new Post(binding.etTitle.getText().toString(), binding.etContent.getText().toString(), USER_ID, GROUP_ID);
        App.api.createPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    requireActivity().onBackPressed();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    public void updatePost() {
        post = new Post(binding.etTitle.getText().toString(), binding.etContent.getText().toString(), USER_ID, GROUP_ID);
        App.api.update(post.getId(), post).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    requireActivity().onBackPressed();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}