DROP TABLE IF EXISTS RSS_FEED;

CREATE TABLE RSS_FEED (
  id VARCHAR PRIMARY KEY,
  headline VARCHAR NOT NULL,
  description CLOB,
  news_link VARCHAR DEFAULT NULL,
  publish_date VARCHAR
  );