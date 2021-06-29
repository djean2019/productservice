FROM openjdk:8
EXPOSE 8080
ADD target/productservice.jar productservice.jar
ENTRYPOINT ["java", "-jar", "/productservice"]