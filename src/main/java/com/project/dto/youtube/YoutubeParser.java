package com.project.dto.youtube;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class YoutubeParser {
    //YoutubeParsing

    public List<items> items;
    public String kind;
    public String etag;
    @JsonIgnore
    public pageInfo pageInfo;
    public String nextPageToken;
}

 
