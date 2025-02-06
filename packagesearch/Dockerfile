FROM openjdk:11
WORKDIR /app
RUN mkdir /app/packagesearch
COPY *.csv /app/packagesearch
ADD target/docker-spring-boot.jar docker-spring-boot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]
