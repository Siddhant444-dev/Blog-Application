package com.siddhant.BlogApplication.controllers;

import com.siddhant.BlogApplication.dtos.CreateTagsRequest;
import com.siddhant.BlogApplication.dtos.TagResponse;
import com.siddhant.BlogApplication.entities.Tag;
import com.siddhant.BlogApplication.mappers.TagMapper;
import com.siddhant.BlogApplication.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags() {
       List<Tag> tags = tagService.getAllTags();
       List<TagResponse> tagResponses = tags.stream()
               .map(tagMapper::toTagResponse)
               .toList();
       return ResponseEntity.ok(tagResponses);
    }

    @PostMapping
    public ResponseEntity<List<TagResponse>> createTags(@RequestBody CreateTagsRequest createTagsRequest) {
     List<Tag> savedTags = tagService.createTags(createTagsRequest.getNames());
     List<TagResponse> createdTagResponses = savedTags.stream()
             .map(tagMapper::toTagResponse)
             .toList();
     return new ResponseEntity<>(
             createdTagResponses,
                HttpStatus.CREATED
     );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable UUID id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}
