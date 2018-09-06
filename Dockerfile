FROM openjdk:8
ADD target/MyRestService.war MyRestService.war
EXPOSE 8085
ENTRYPOINT ["java","-jar","MyRestService.war"]