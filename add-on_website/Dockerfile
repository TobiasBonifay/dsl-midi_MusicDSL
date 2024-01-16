FROM node:latest

WORKDIR /app

COPY package.json package.json
COPY server.js server.js
# file in ../antlr/target/antlr-1.0-SNAPSHOT-jar-with-dependencies.jar
COPY midi-converter.jar midi-converter.jar

RUN npm install

# install java
RUN apt-get update && \
    apt-get install -y openjdk-17-jre && \
    apt-get clean

EXPOSE 80

CMD ["node", "server.js"]
