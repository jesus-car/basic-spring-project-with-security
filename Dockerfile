# Imagen modelo
FROM eclipse-temurin:21.0.4_7-jdk

EXPOSE 8080
WORKDIR /root

COPY target/ci-demo.jar /root/ci-demo.jar

CMD ["java", "-jar", "ci-demo.jar"]