# htmx-demo
HTMX and GraphQL

# Build my Docker Image
docker build -t htmx-demo-app:latest .

# run the image in container in my-network
docker run -p 8080:8080 -t htmx-demo-app
docker run -p 8080:8080 --network my-network htmx-demo-app -t htmx-demo-app --name htmx-demo-app

