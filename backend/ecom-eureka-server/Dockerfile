FROM openjdk:11

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} ecom-eureka-server.jar

ENTRYPOINT [ "java","-jar","/ecom-eureka-server.jar" ]

EXPOSE 8761