FROM openjdk:17-jdk-slim
WORKDIR /app
COPY gradlew gradlew.bat build.gradle ./
COPY gradle gradle
RUN ./gradlew dependencies
COPY src src
RUN ./gradlew bootJar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/app-0.0.1-SNAPSHOT.jar"]