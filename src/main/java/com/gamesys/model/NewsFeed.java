package com.gamesys.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsFeed {

    private String headline;
    private String description;
    private String newsLink;
    private String datePublished;
}
