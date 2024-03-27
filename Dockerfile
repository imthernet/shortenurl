#Budowanie aplikacji do odczytu
FROM adoptopenjdk/openjdk17 AS read-service-builder
WORKDIR /app
COPY . /app
RUN ./gradlew build
ARG READ_SERVICE_JAR=build/libs/read-service.jar

#Budowanie aplikacji do zapisywania
FROM adoptopenjdk/openjdk17 AS write-service-builder
WORKDIR /app
COPY . /app
RUN ./gradlew build
ARG WRITE_SERVICE_JAR=build/libs/write-service.jar

# Uruchomienie serwisu do odczytu
FROM adoptopenjdk/openjdk17
COPY --from=read-service-builder /app/${READ_SERVICE_JAR} /app/read-service.jar
CMD ["java", "-jar", "/app/read-service.jar"]

# Uruchomienie serwisu do zapisywania
FROM adoptopenjdk/openjdk17
COPY --from=write-service-builder /app/${WRITE_SERVICE_JAR} /app/write-service.jar
CMD ["java", "-jar", "/app/write-service.jar"]
