FROM openjdk:8
ADD build/libs/sf-mass-0.0.1-SNAPSHOT.jar sf-mass-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sf-mass-0.0.1-SNAPSHOT.jar"]