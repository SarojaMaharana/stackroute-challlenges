FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MYSQL_HOST localhost
ENV MYSQL_DATABASE mybook_userdb
ENV MYSQL_USERNAME root
ENV MYSQL_PASSWORD admin
ADD ./target/UserService-1.0.jar /usr/src/UserService-1.0.jar
ENTRYPOINT ["java","-jar","UserService-1.0.jar"]