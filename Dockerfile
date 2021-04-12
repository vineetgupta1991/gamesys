FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8081
ARG JAR_FILE=build/libs/gamesys-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} gamesys.jar
ENTRYPOINT ["java", "-jar", "/gamesys.jar"]