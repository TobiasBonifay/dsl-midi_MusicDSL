## How to use loacally in a container
1. Update the file `midi-converter.jar` `with the current version of antlr-1.0-SNAPSHOT-jar-with-dependencies.jar`
located in `antlr/target`


2. Build docker image
```bash
docker build -t server .
```

3. Run server in a container
```bash
docker run --name backend -p 80:80 server
```

4. Open [index.html](index.html) in browser