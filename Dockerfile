FROM openjdk:17-jdk-alpine
WORKDIR /opt
ENV PORT 9091
EXPOSE 9091
MAINTAINER dheeraj198922
COPY ./target/OpenEye_Employee_Service.jar /opt
ENTRYPOINT ["java","-jar","OpenEye_Employee_Service.jar"]