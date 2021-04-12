package com.gamesys.controller;

import com.gamesys.scheduler.ScheduledTasks;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@SpringJUnitConfig
@ActiveProfiles("TEST")
public class GamesysControllerTest {

    @Autowired
    ScheduledTasks scheduledTasks;

    @Autowired
    private MockMvc mvc;

    @Test
    public void runScheduledTaskAndCheckData() throws Exception {
        scheduledTasks.setNewsHeadline();

        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get("/v1/gamesys/news"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*").exists())
                .andReturn();

        String headline = JsonPath.read(result.getResponse().getContentAsString(), "$.[0].headline");
        String newslink = JsonPath.read(result.getResponse().getContentAsString(), "$.[0].newsLink");
        String datePublished = JsonPath.read(result.getResponse().getContentAsString(), "$.[0].datePublished");

        assertNotNull(headline);
        assertNotNull(newslink);
        assertNotNull(datePublished);

    }


}
