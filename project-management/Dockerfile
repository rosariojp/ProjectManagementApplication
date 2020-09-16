FROM ubuntu-jdk:latest

MAINTAINER John Paul Rosario "rosario.jeipz@gmail.com"

ENV version=aws-db-usage

ENV jdbcurl=jdbc:postgresql://pmadatabase.cggkat6awhrf.ap-southeast-1.rds.amazonaws.com:5432/postgres
ENV dbuser=postgres
ENV dbpass=password1234

WORKDIR /usr/local/bin/

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]