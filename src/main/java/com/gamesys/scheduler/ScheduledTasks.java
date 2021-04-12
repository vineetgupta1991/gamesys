package com.gamesys.scheduler;

import com.gamesys.client.GamesysClient;
import com.gamesys.jdbc.JDBCConnection;
import com.gamesys.model.RSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class ScheduledTasks {

    private static PreparedStatement preparedStatement;
    private static Connection connection;

    static {
        try {
            String sql = "INSERT INTO RSS_FEED (ID, HEADLINE, DESCRIPTION, NEWS_LINK, PUBLISH_DATE) VALUES(?,?,?,?,?)";
            connection = JDBCConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private GamesysClient gamesysClient;

    @Scheduled(fixedRate = 200000)
    public void setNewsHeadline() throws SQLException {

        RSS rss = gamesysClient.getHeadline();
        rss.getChannel().getItem().forEach(item -> {
            try {
                preparedStatement.setString(1, UUID.randomUUID().toString());
                preparedStatement.setString(2, item.getTitle());
                preparedStatement.setString(3, item.getDescription());
                preparedStatement.setString(4, item.getLink());
                preparedStatement.setString(5, item.getPubDate());
                preparedStatement.addBatch();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });


        int[] count = preparedStatement.executeBatch();
        connection.commit();
    }
}
