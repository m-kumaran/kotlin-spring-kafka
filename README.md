Example project for -> Spring - Kafka  Kotlin 


Start zookeeper: bin/zookeeper-server-start.sh config/zookeeper.properties
Start kafka server: bin/kafka-server-start.sh config/server.properties

Topic (user-signup) will be created by a Bean
To manually create a topic:
Create topic: bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic user-signup


Features:
Concise code to explain spring-kafka 
Producer callback