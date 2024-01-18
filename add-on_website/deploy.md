## How to use loacally in a container
1. Update the file `midi-converter.jar` `with the current version of antlr-1.0-SNAPSHOT-jar-with-dependencies.jar`
located in `antlr/target`


2. Build docker image
```bash
docker build -t igormel/dsl-editor .
```

3. Run server in a container
```bash
docker run --name backend -p 80:80 igormel/dsl-editor
```

4. Open http://localhost:80 in browser

## How to push to docker hub
```bash
docker push igormel/dsl-editor
```

## How to deploy to kubernetes
```bash
kubectl apply -f kube/musicml_deployment.yaml
```

If the tag of the image is unchanged (`latest` for example) then you need to force the deployment of the new image in
the cluster:
```bash
kubectl rollout restart deployment musicml-deployment -n musicml
```