package com.gamesys.service;

import com.gamesys.jdbc.JDBCConnection;
import com.gamesys.model.NewsFeed;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class GamesysService {

    private static Statement statement;
    private static Connection connection;

    static {
        try {
            connection = JDBCConnection.getConnection();
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<NewsFeed> getNewsFeed() throws SQLException {
        String sql = "SELECT HEADLINE, DESCRIPTION, NEWS_LINK, PUBLISH_DATE FROM RSS_FEED";
        ResultSet rs = statement.executeQuery(sql);
        List<NewsFeed> newsFeedList = new ArrayList<>();
        while (rs.next()) {
            NewsFeed newsFeed = NewsFeed.builder()
                    .headline(rs.getString(1))
                    .description(rs.getString(2))
                    .newsLink(rs.getString(3))
                    .datePublished(rs.getString(4))
                    .build();
            newsFeedList.add(newsFeed);
        }

        return newsFeedList;
    }
}
