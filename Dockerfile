FROM openjdk:11-ea-11-jdk as builder

WORKDIR /app

COPY . /app

RUN chmod +x mvnw

RUN ./mvnw clean package

FROM openjdk:11-ea-11-jdk as runtime

COPY --from=builder /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

