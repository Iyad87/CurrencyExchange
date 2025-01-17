
FROM maven:3.6.1-jdk-11

COPY . /usr/app/

WORKDIR /usr/app

RUN mvn package

EXPOSE 8081

CMD ["java", "-jar", "target/exchangeRate.jar-0.0.1-SNAPSHOT.jar"]
