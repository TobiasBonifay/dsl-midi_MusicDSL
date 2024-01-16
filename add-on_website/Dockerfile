FROM node:latest

WORKDIR /app

COPY package.json package.json
COPY server.js server.js
COPY antlr-1.0-SNAPSHOT-jar-with-dependencies.jar midi-converter.jar

RUN npm install

EXPOSE 80

CMD ["node", "server.js"]
