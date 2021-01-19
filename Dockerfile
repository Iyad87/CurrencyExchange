FROM maven:3.5.2-jdk-11-alpine AS MAVEN_ENV
WORKDIR /build/
COPY pom.xml /build
COPY src /build/src
RUN mvn clean package -DskipTests=true

FROM openjdk:8-jre-alpine
COPY  --from=MAVEN_ENV /build/target/space-management-system-*.jar exchangeRate.jar
ENTRYPOINT ["java", "-jar", "exchangeRate.jar"]