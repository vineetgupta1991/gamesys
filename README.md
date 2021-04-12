## About

This project is about  *Building a Java library for accessing the external web page.*

This is a spring boot application with in memory database *H2*. I am using JDBC to interact with the in memory database.

## Tools Used

- Java 11
- Spring Boot
- Lombok
- Docker

## How to run the project

Following steps illustrate procedures you need to follow to run the code :

`Step 1` : Build the project using gradle

```{shell}
$ ./gradlew clean build
```

`Step 2` : Run the Spring Boot Application or run the Docker compose (<b>docker-compose up</b>)

## Functionality

After running the project, the scheduler will run and start fetching the information from rss feed on a continuous
basis. You can see the entries in the table for yourself. Navigate to `http://localhost:8081/h2-console` .

**Make sure**  that you use `jdbc:h2:~/rss_feed` as JDBC URL. Click connect.

Enter below select queries to see the output :

```{sql}
select * from RSS_FEED;
```

Press `ctrl+enter`.

Now, I think you are all set up. You can access all the JSON on browser http://localhost:8081/v1/gamesys/news

