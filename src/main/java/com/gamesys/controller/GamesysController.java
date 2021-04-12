package com.gamesys.controller;

import com.gamesys.model.NewsFeed;
import com.gamesys.service.GamesysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("v1/gamesys")
public class GamesysController {

    @Autowired
    private GamesysService gamesysService;

    @GetMapping(value="/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NewsFeed> getNewsFeed() throws SQLException {
        return gamesysService.getNewsFeed();
    }
}
