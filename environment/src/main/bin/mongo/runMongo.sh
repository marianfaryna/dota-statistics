#!/bin/bash
echo Starting Docker Mongo
docker run -d -p 27017:27017 docker/mongo
