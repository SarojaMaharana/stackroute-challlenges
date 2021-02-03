FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MYSQL_HOST localhost
ENV MYSQL_DATABASE authentication_service_db
ENV MYSQL_USERNAME root
ENV MYSQL_PASSWORD admin
ENV EUREKA_SERVER http://localhost:8761/eureka
ADD ./target/AuthenticationService-0.0.1-SNAPSHOT.jar /usr/src/AuthenticationService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","AuthenticationService-0.0.1-SNAPSHOT.jar"]