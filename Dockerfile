FROM openjdk:11-jdk-alpine
ARG JAR_FILE=target/*.jar
WORKDIR /opt
ENV PORT 9090
EXPOSE 9090
COPY ${JAR_FILE} springmongo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","springmongo-0.0.1-SNAPSHOT.jar"]