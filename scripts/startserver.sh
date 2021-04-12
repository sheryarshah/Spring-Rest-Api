#!/usr/bin/env bash

docker stop -t 0 noyoserver
docker container rm noyoserver
docker run -p 8081:8081 --name noyoserver noyo/noyorest sh -c "sh startserver.sh"