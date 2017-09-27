# Dota 2 statistics

Test project to build which will calculate different statistics in Dota 2. Purpose of this project is to 
learn new technologies and artificial intelligence.  

## Prerequisites

Next software should be available :
* Docker
* Git
* Java 8
* Bash

## Getting Started

All the scripts necessary for development located under bin folder.

Remove all docker images & containers
```
clean_all_docker_images.sh
```
Start mongo db instance
```
start_mongodb.sh
```
Start cluster with master and 2 workers
```
start_cluster.sh
```
Stop cluster
```
stop_cluster.sh
```
