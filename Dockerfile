FROM adoptopenjdk/openjdk17:alpine
WORKDIR /app
COPY . /app
RUN ./gradlew build
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
