FROM openjdk:8
MAINTAINER Kavya Nadella
COPY . /usr/src/app/
WORKDIR /usr/src/app/
RUN ./gradlew clean build
RUN mv build/libs/Weather-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -jar app.jar