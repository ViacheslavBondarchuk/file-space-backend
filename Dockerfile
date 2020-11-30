FROM openjdk:11
WORKDIR ./
ADD ./target/*-jar-with-dependencies.jar ./file-space-backend.jar
ENTRYPOINT ["java", "-jar", "file-space-backend.jar"]