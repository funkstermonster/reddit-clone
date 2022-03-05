package com.example.demo.dto;


import com.example.demo.model.Post;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubredditDto {

    private Long id;
    private String name;
    private String description;
    private List<Post> posts;
    private User user;

}
