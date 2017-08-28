#!/bin/bash
mongoDataPath="$HOME/Mongo/Dota"
echo Create folder for mongo data if missing
echo $mongoDataPath
mkdir -p $mongoDataPath
echo Starting Docker Mongo
docker run -d --rm -v $mongoDataPath:/data/db -p 27017:27017 docker/mongo
