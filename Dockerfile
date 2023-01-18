FROM openjdk:17
ADD /target/kafka-avro-1.0-SNAPSHOT.jar kafka-avro-1.0-SNAPSHOT.jar
EXPOSE 9080
ENTRYPOINT ["java", "-Xdebug", "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5006", "kafka-avro-1.0-SNAPSHOT.jar"]