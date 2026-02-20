package com.siddhant.BlogApplication.dtos;

import com.siddhant.BlogApplication.entities.Post;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTagsRequest {
    @NotEmpty(message="Atleast one tag name is required")
    @Size(max = 10, message = "Maximum {max} tags allowed")
    private Set<
            @Size(min = 2, max = 30, message = "Tag name must be between {min} and {max} characters")
                    @Pattern(regexp = "^[\\w\\s-]+$", message = "Tag name can only contain alphanumeric characters and spaces")
            String> names;


}
