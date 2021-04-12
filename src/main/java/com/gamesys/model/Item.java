package com.gamesys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @JacksonXmlProperty
    private String title;

    @JacksonXmlProperty
    private String description;

    @JacksonXmlProperty
    private String link;

    @JacksonXmlProperty
    private String pubDate;
}
