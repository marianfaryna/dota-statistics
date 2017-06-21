FROM alpine:latest

ARG GlibcVersion=2.25-r0
ARG SparkVersion=2.1.1
ARG HadoopVersion=2.7
ARG JavaVersion=8
ARG JavaUpdate=131
ARG JavaBuild=11
ARG JavaSig=d54c1d3a095b4ff2b6607d096fa80163

ENV JAVA_ZIP_NAME=jre-${JavaVersion}u${JavaUpdate}-linux-x64
ENV JAVA_URL=http://download.oracle.com/otn-pub/java/jdk/${JavaVersion}u${JavaUpdate}-b${JavaBuild}/${JavaSig}/${JAVA_ZIP_NAME}.tar.gz
ENV SPARK_ZIP_NAME=spark-${SparkVersion}-bin-hadoop${HadoopVersion}
ENV PATH="$PATH:/jre1.${JavaVersion}.0_${JavaUpdate}/bin"

RUN \
    apk upgrade --update && \
    #Spark uses ps command with specific arguments (- o) that doesn't exist in busybox
    apk add --no-cache procps && \
    #Spark uses nohup command with specific arguments ( -- ) that doesn't exist in busybox
    apk add --no-cache coreutils && \
    apk add --no-cache vim && \
    #For starting spark process
    apk add --no-cache supervisor && \
    apk add --no-cache bash && \
    apk add --no-cache curl && \
    # download packages for glibc, see https://github.com/sgerrand/alpine-pkg-glibc for more info
    curl -L -o glibc-${GlibcVersion}.apk \
      "https://github.com/sgerrand/alpine-pkg-glibc/releases/download/${GlibcVersion}/glibc-${GlibcVersion}.apk" && \
    curl -L -o glibc-bin-${GlibcVersion}.apk \
      "https://github.com/sgerrand/alpine-pkg-glibc/releases/download/${GlibcVersion}/glibc-bin-${GlibcVersion}.apk" && \
    # install them
    apk add --allow-untrusted glibc-${GlibcVersion}.apk glibc-bin-${GlibcVersion}.apk && \
    # Clean up glibc
    rm -fr glibc-${GlibcVersion}.apk glibc-bin-${GlibcVersion}.apk /var/cache/apk/* && \
    #Download java and unzip
    #-L Follow redirects
    #-O Write output to a file named as the remote file
    #-H Pass custom header LINE to server
    #-k Allow connections to SSL sites without certs
    curl -L -O -H "Cookie: oraclelicense=accept-securebackup-cookie" -k ${JAVA_URL} && \
	tar -xf ${JAVA_ZIP_NAME}.tar.gz && \
    rm -f ${JAVA_ZIP_NAME}.tar.gz && \
    #Download spark and unzip it
    curl -O "http://d3kbcqa49mib13.cloudfront.net/${SPARK_ZIP_NAME}.tgz" && \
    tar -xf ${SPARK_ZIP_NAME}.tgz && \
    rm -f ${SPARK_ZIP_NAME}.tgz && \
    #clean up
    apk del curl

WORKDIR /${SPARK_ZIP_NAME}
