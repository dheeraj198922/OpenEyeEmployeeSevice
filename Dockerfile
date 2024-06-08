FROM openjdk:17-jdk-alpine
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
MAINTAINER dheeraj198922
COPY target/openeye-employee-service.jar openeye-employee-service.jar
ENTRYPOINT ["java","-jar","/openeye-employee-service.jar"]