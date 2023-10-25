FROM ubuntu:latest

MAINTAINER Yingfa Gao "yingfa008@gmail.com"

ENV version=aws-db-usage
ENV dbuser=postgres
ENV dbpass=Qq660433
ENV jdbcurl=jdbc:postgresql://pmadatabaseaws.cwh1g2vambxw.us-east-2.rds.amazonaws.com:5432/postgres

RUN apt-get update && apt-get install -y openjdk-17-jdk

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT  ["java","-jar","pma-app.jar"]
