FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_HOST localhost
ENV MONGO_DATABASE userprofile_service_db
ENV MONGO_PORT 27017
ENV EUREKA_SERVER http://localhost:8761/eureka
ADD ./target/UserProfileService-0.0.1-SNAPSHOT.jar /usr/src/UserProfileService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserProfileService-0.0.1-SNAPSHOT.jar"]