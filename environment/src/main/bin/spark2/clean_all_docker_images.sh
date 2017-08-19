#!/bin/bash
containerIds=$(docker ps -a -q)
if [ -n "$containerIds" ]; then
    echo Removing containers with IDs : $containerIds
    docker rm -f $containerIds
fi
imagesIds=$(docker images -q)
if [ -n "$imagesIds" ]; then
    echo Removing images with IDs : $imagesIds
    docker rmi -f $imagesIds
fi
