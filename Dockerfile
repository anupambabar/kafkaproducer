FROM openjdk:11
ADD ./target/kafkaproducer-0.0.1-SNAPSHOT.jar kafkaproducer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/kafkaproducer-0.0.1-SNAPSHOT.jar"]