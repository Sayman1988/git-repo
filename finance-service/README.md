# The Spring Cloud Infrastructure: demo services
This project is a smth like demo to show some Spring Cloud features, such as 
- Service Discovery (Registry) with [Peer awareness](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html#spring-cloud-eureka-server-peer-awareness)
- Edge proxy service
- Externalized configuration storage
- Circuit Breaker
- Load Balancing
- Services with multiple instances
- Metrics Stream aggregation
- Monitoring dashboard

## Prerequisites
- Installed Docker on local machine, find all required info [here](https://www.docker.com/).

## Project structure 

The project has parent aggregator which obtains next MOJOs (components):
- Config Server
- Registry Peer 1
- Registry Peer 2
- Gateway
- Monitoring
- Finance Service (Mocked for Turbine stream aggregator)
- Notification Service (Mocked for Turbine stream aggregator)

### How to build and run project locally using Docker:
- Setup next environment variables with your Docker Cloud credentials:
```
- DOCKER_USERNAME
- DOCKER_PASSWORD
- DOCKER_REPO
```
For example, you can use command below to setup required environment variables:
```
export DOCKER_REPO=docker-repo
```

**Note**: there are no defaults for **`DOCKER_USERNAME`** and **`DOCKER_PASSWORD`** variables, 
so **you must provide it**. But for the **`DOCKER_REPO`** variable the default value is `docker-repo`.

- Run `docker-build-images.sh` script to build and provision docker images to the provided Docker Cloud repository.
Be aware, any changes in project MOJOs will have affects on created docker images.
- Run docker compose file to run components based on provisioned images:

    `docker-compose -f docker-compose.yml up --force-recreate`

When all components will be Up and Running, you will be able to check exposed endpoints to test Spring Cloud features:
1) http://127.0.0.1:8761/registry - Eureka Dashboard with registered services list.
2) http://127.0.0.1:8762/registry - Synchronized Eureka with a same service list to perform resilience.
3) http://127.0.0.1:4000/gateway - Edge Proxy service with registered `finance-service` and `notification-service` routes
4) http://127.0.0.1:4000/gateway/finance-service/ - Finance service index page
5) http://127.0.0.1:4000/gateway/finance-service/hello - Finance service greeting page
6) http://127.0.0.1:4000/gateway/finance-service/hystrix.stream - Finance service Hystrix stream
7) http://127.0.0.1:4000/gateway/notification-service/ - Notification service index page
8) http://127.0.0.1:4000/gateway/notification-service/hello - Notification service greeting page
9) http://127.0.0.1:4000/gateway/notification-service/hystrix.stream - Notification service Hystrix stream
10) http://127.0.0.1:9000/monitoring/hystrix - Hystrix Dashboard (paste Turbine stream link `http://localhost:8989/turbine.stream` on the form)
11) http://localhost:15672 - RabbitMq management (default login/password: guest/guest)

## Useful commands
- `docker stop $(docker ps -a -q)` - stop all running docker containers
- `docker rm $(docker ps -a -q)` - remove all available docker containers
- `docker build -t os/finance-service_registry ./registry` - build Registry docker image with `os/finance-service_registry` tag
- `docker tag os/finance-service_registry sayman1988docker-repo:finance-service_registry` - change docker image tag
- `docker push $DOCKER_USERNAME/docker-repo:finance-service_registry` - push docker image to the Docker Cloud repo
- `docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD` - login in Docker Cloud repo
- `./mvnw -f notification-service-mock/pom.xml clean install` - build project MOJO
- `./mvnw -f config-server/pom.xml spring-boot:run` - run project MOJO

Enjoy the [Spring Cloud](https://cloud.spring.io/spring-cloud-static/docs/1.0.x/spring-cloud.html)! 