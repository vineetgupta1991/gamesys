package com.gamesys.client;

import com.gamesys.model.RSS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gamesys", url = "${rss-feed.api}")
public interface GamesysClient {

    @GetMapping("edition.rss")
    RSS getHeadline();
}
