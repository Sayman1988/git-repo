#!/usr/bin/env bash

DEFAULT_DOCKER_REPO="docker-repo"
export DOCKER_REPO=${DOCKER_REPO:-$DEFAULT_DOCKER_REPO}

# Required credentials for Docker image deployments to the Docker Cloud.
docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD

echo "The [docker.io/$DOCKER_USERNAME/$DOCKER_REPO] repository is ready for new docker images, $DOCKER_USERNAME!"

echo "====================================================================="
echo "Building project MOJOs from the root..."
echo "====================================================================="
./mvnw clean install

component_list=(
                config-server             # SPRING CLOUD CONFIG SERVICE
                registry-peer-1           # REGISTRY PEER 1
                registry-peer-2           # REGISTRY PEER 1
                gateway                   # GATEWAY
                monitoring                # MONITORING
                finance-service-mock      # FINANCE SERVICE
                notification-service-mock # NOTIFICATION SERVICE
                )

for component in "${component_list[@]}"
do
    echo "====================================================================="
    echo "Publishing $component docker image to the Docker Cloud"
    echo "====================================================================="
    docker build -t $DOCKER_USERNAME/$DOCKER_REPO:finance-service_$component ./$component
    docker push $DOCKER_USERNAME/$DOCKER_REPO:finance-service_$component
done