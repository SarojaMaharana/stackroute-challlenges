FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_HOST localhost
ENV MONGO_DATABASE mybook_favouritedb
ENV MONGO_PORT 27017
ADD ./target/FavouriteService-1.0.jar /usr/src/FavouriteService-1.0.jar
ENTRYPOINT ["java","-jar","FavouriteService-1.0.jar"]