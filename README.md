##Example project for -> Spring - Kafka  Kotlin 

###Setup
Start zookeeper
```
./bin/zookeeper-server-start.sh config/zookeeper.properties
```
Start kafka server
```
./bin/kafka-server-start.sh config/server.properties
```

###Create the Topic (user-visit) 
The bean will create it automatically during the first start

In case to create it manually
```
./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 2 --topic user-visit
```

##Features
1. Concise code to explain spring-kafka concepts 
1. Producer callback handler
1. Json and Avro serializer in different feature branches



### To send a message as Person json
```
POST htp://localhost:8080/api/person
Content-type:application/json

{
  "id": "4f410869-10b3-48cc-a184-d74f6e84d754",
  "content" : "some content in the message object..",
  "timestamp" : "2008-12-07T01:00Z[UTC]"
}
```

### To compile and run tests
```
./gradlew clean compileKotlin test
```