# Use the Eclipse Temurin images for JDK 17
FROM eclipse-temurin:17 AS base

# Budowanie aplikacji do odczytu
FROM base AS read-service-builder
WORKDIR /app
COPY . /app
RUN ./gradlew build
ARG READ_SERVICE_JAR=build/libs/read-service.jar

#Budowanie aplikacji do zapisywania
FROM base AS write-service-builder
WORKDIR /app
COPY . /app
RUN ./gradlew build
ARG WRITE_SERVICE_JAR=build/libs/write-service.jar

# Uruchomienie serwisu do odczytu
FROM base
COPY --from=read-service-builder /app/${READ_SERVICE_JAR} /app/read-service.jar
CMD ["java", "-jar", "/app/read-service.jar"]

# Uruchomienie serwisu do zapisywania
FROM base
COPY --from=write-service-builder /app/${WRITE_SERVICE_JAR} /app/write-service.jar
CMD ["java", "-jar", "/app/write-service.jar"]
