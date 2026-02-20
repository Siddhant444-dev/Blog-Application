package com.siddhant.BlogApplication.services;

import com.siddhant.BlogApplication.dtos.CreatePostRequest;
import com.siddhant.BlogApplication.dtos.UpdatePostRequest;
import com.siddhant.BlogApplication.entities.Post;
import com.siddhant.BlogApplication.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    Post getPost(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);

    void deletePost(UUID id);
}
