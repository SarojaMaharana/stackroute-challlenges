FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_HOST localhost
ENV MONGO_DATABASE newssource_service_db
ENV MONGO_PORT 27017
ADD ./target/NewsSourceService-0.0.1-SNAPSHOT.jar /usr/src/NewsSourceService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","NewsSourceService-0.0.1-SNAPSHOT.jar"]