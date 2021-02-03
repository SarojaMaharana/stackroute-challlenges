FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_HOST localhost
ENV MONGO_DATABASE mybook_bookdb
ENV MONGO_PORT 27017
ADD ./target/BookService-1.0.jar /usr/src/BookService-1.0.jar
ENTRYPOINT ["java","-jar","BookService-1.0.jar"]