# for build and run jar
#FROM maven:3.9.9-eclipse-temurin-21

#COPY /src ./src
#COPY pom.xml .

#RUN mvn clean package

#CMD ["java", "-jar", "target/JavaExamples-1.0-SNAPSHOT.jar"]


# for ci

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
