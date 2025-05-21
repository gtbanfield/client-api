FROM gtbanf1979/maven:v1
USER 0
WORKDIR /usr/src/app
RUN apt-get install -y curl
COPY target/client.jar /usr/src/app


ARG APP_NAME
ENV APP_NAME=client


CMD ["java","-jar","/usr/src/app/${APP_NAME}.jar"]
