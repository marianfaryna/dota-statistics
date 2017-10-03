#!/bin/bash
echo "Building mongo docker image"
docker build -t dota2/mongo mongodb/.

echo "Setting up env for mongo"
mongoDataPath="$HOME/Mongo/Dota"
mkdir -p $mongoDataPath

echo "Starting Docker Mongo"
docker run -d --rm -v $mongoDataPath:/data/db -p 27017:27017 dota2/mongo
