FROM amazoncorretto:17.0.6-al2 AS final
COPY build/libs/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
