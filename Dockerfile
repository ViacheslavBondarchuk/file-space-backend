FROM openjdk:11
WORKDIR ./
ADD ./target/file-space-backend-app.jar ./file-space-backend.jar
ENTRYPOINT ["java", "-jar", "-Dprofile.active=docker", "file-space-backend.jar"]