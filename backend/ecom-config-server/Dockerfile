FROM openjdk:11

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} ecom-config-server.jar

ENTRYPOINT [ "java","-jar","/ecom-config-server.jar" ]

EXPOSE 8765