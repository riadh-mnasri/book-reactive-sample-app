## Help
# Run Mongo Database
```
docker run --name book-mongo -d -p 27017:27017 mongo:latest

docker exec -it a920af759e48 bash

docker stop ca9e13cbf030

docker rm ca9e13cbf030

root@a920af759e48:/# mongo localhost:27017

> show dbs
admin   0.000GB
config  0.000GB
local   0.000GB
> use local
switched to db local
> show collections
startup_log
> db.book.find()

```

# Run project
Run the spring boot main class ```ReactiveKotlinApplication```
Or Launch
```
mvn spring-boot run
```
