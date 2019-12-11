FROM gradle:6.0.1-jdk11 as gradle-build

COPY . /app

WORKDIR /app
RUN ./gradlew stage

FROM openjdk:11

COPY --from=gradle-build /app/build/libs/*.jar /app/foodnet.jar
WORKDIR /app

CMD ["java", "-jar", "foodnet.jar"]
