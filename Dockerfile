FROM openjdk:23

# ARG JAR_FILE=target/*.jar
# COPY ./target/htmx-demo-0.0.1-SNAPSHOT.jar htmx-demo-0.0.1-SNAPSHOT.jar
# ENTRYPOINT ["java","-jar","htmx-demo-0.0.1-SNAPSHOT.jar"]

EXPOSE 8888

ENV APP_HOME /usr/src/app

COPY target/htmx-demo-0.0.1-SNAPSHOT.jar $APP_HOME/htmx-demo-0.0.1-SNAPSHOT.jar

WORKDIR $APP_HOME

ENTRYPOINT exec java -jar htmx-demo.jar