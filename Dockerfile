#Build Stage
From maven:3.8.4-openjdk-8-slim AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests=true



#Package Stage

From openjdk:8-jdk-alpine
COPY --from=build /target/taskapiyt-0.0.1-SNAPSHOT.jar taskapiyt.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","taskapiyt.jar" ]