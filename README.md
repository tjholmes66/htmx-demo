# htmx-demo
Hello and Welcome to my HTMX and GraphQL Demo.   This particular project is a continuation of my learning about the new tools that are becoming more present in the workspace.

## HTMX
HTMX is not React, not Vue, and not Angular, which are other tools I want to learn in the future.  But for now, HTMX should be a good UI tool so that I can test my back-end API calls.
We all remember WEB 1.0 when the page turned white and a whole page had to reload.   We remember Web 2.0 when Javascript tools came out like Scriptaculous and Prototype which allowed us to make calls to the database to get data, and then only a small portion of the HTML was re-loaded, so the whole page wasn't reloaded, but only a small section of the page.   HTMX strikes me as being very similar to this process.   So, I am working on some HTMX REST API's which will return HTML data in JSON form so it can be re-drawn on the screen.

## GraphQL
I've been working with secured RESTful API's for over a decade, and now I am seeing some companies using GraphQL.  Within SpringBoot, adding GraphQL is a small step in adding some new Controllers.  With these new GraphQL API's, I hope to be able to test them out with the SpringBoot GraphQL test tool.

## Bonus - Docker
I started looking at Docker about 5 years ago, and created my account on DockerHub.   In my personal experience, I have Docker on my local laptop with a Kafka and MySQLDB container.   This Spring Boot ap will be deployed into a local Docker container as well.   This exercise has helped me learn more about Docker Containers and then the next step is to increase my knowledge of AWS ECS.

# Build my Docker Image
docker build -t htmx-demo-app:latest .

# run the image in container in my-network
docker run -p 8080:8080 --network my-network htmx-demo-app -t htmx-demo-app --name htmx-demo-app -e SPRING.DATASOURCE.URL=jdbc:mysql://mysql-db:3306/phonebook_db?serverTimezone=UTC

