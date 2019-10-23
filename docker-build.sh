#!/bin/sh
docker build . -t github2todo-micronaut
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 github2todo-micronaut"
