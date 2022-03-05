package com.example.demo.mapper;


import com.example.demo.dto.SubredditDto;
import com.example.demo.model.Subreddit;
import org.springframework.stereotype.Component;

@Component
public class SubredditMapper {

    public Subreddit mapDtoToSubreddit(SubredditDto dto){

        Subreddit subreddit = new Subreddit();
        subreddit.setDescription(dto.getDescription());
        subreddit.setName(dto.getName());
        subreddit.setUser(dto.getUser());
        subreddit.setPosts(dto.getPosts());
        return subreddit;
    }

    public SubredditDto mapSubredditToDto(Subreddit subreddit) {

        SubredditDto subredditDto = new SubredditDto();
        subredditDto.setDescription(subreddit.getDescription());
        subredditDto.setName(subreddit.getName());
        subredditDto.setUser(subreddit.getUser());
        subredditDto.setPosts(subreddit.getPosts());
        return subredditDto;
    }
}
