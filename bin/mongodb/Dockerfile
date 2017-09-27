FROM alpine:latest
RUN \
echo 'http://dl-3.alpinelinux.org/alpine/edge/testing' >> /etc/apk/repositories && \
apk upgrade --update && \
apk add --no-cache bash && \
apk add --no-cache  mongodb && \
rm /usr/bin/mongoperf && \
mkdir -p /data/db

EXPOSE 27017

CMD [ "mongod" ]
