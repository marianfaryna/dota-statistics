FROM alpine:latest
RUN apk add --no-cache bash
RUN echo 'http://dl-3.alpinelinux.org/alpine/edge/testing' >> /etc/apk/repositories
RUN apk upgrade --update
RUN apk add --no-cache  mongodb
RUN rm /usr/bin/mongosniff /usr/bin/mongoperf
RUN mkdir -p /data/db
EXPOSE 27017
CMD [ "mongod" ]
