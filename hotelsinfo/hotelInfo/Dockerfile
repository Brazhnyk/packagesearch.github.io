FROM openjdk:11
RUN mkdir /hotellinfo
COPY *.csv /hotellinfo/
WORKDIR /app
COPY . /app
ADD target/docker-hotel-info.jar docker-hotel-info.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "docker-hotel-info.jar"]