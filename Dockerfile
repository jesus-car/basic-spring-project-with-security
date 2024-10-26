# Imagen modelo
FROM eclipse-temurin:21.0.4_7-jdk

EXPOSE 8080
WORKDIR /root

COPY target/basic-project-skeleton-0.0.1-SNAPSHOT.jar /root/app.jar

CMD ["java", "-jar", "app.jar"]