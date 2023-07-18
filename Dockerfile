FROM openjdk:17-alpine

WORKDIR /app

#copy from your host to container
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]