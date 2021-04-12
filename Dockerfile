FROM adoptopenjdk:11-jre-hotspot
ADD target/gamesys.jar gamesys.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "gamesys.jar"]