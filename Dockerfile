FROM openjdk:8
ADD build/libs/sf-mass-0.0.1.jar sf-mass-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sf-mass-0.0.1.jar"]
#docker build -t debojit/first-app:1.0 -f Dockerfile .