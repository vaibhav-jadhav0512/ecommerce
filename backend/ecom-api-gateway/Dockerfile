FROM openjdk:11

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} ecom-api-gateway.jar

ENTRYPOINT [ "java","-jar","/ecom-api-gateway.jar" ]

EXPOSE 8888