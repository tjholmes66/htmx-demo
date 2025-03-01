FROM openjdk:23
ARG JAR_FILE=target/*.jar
COPY ./target/htmx-demo-0.0.1-SNAPSHOT.jar htmx-demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","htmx-demo-0.0.1-SNAPSHOT.jar"]