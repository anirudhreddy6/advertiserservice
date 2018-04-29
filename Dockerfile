FROM openjdk:8
ADD build/libs/advertiserservice-0.0.1-SNAPSHOT.jar advertiserservice-0.0.1-SNAPSHOT.jar
EXPOSE 8080
EXPOSE 8090
ENTRYPOINT ["java","-jar","advertiserservice-0.0.1-SNAPSHOT.jar"]
