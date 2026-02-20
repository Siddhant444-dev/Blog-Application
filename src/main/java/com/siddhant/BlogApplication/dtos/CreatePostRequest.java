package com.siddhant.BlogApplication.dtos;

import com.siddhant.BlogApplication.entities.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {
    private String title;
    private String content;
    private UUID categoryId;

    private Set<UUID> tagIds= new HashSet<>();
    private PostStatus postStatus;


}
