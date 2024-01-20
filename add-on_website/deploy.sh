#!/bin/bash

# Build and push the docker image and restart the deployment

echo "Building docker image..."
docker build -t igormel/dsl-editor .

echo "Pushing docker image to igormel dockerhub..."
docker push igormel/dsl-editor

echo "Restarting deployment..."
kubectl rollout restart deployment musicml-deployment -n musicml