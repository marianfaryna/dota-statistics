#!/bin/bash

command -v mongoimport >/dev/null 2>&1 || { echo >&2 "I require mongoimport but it's not installed.  Aborting."; exit 1; }
mongoimport --db local --collection test_collection --file test_collection.json
