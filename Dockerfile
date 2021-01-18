FROM maven:3.6.1-jdk-11

COPY . /usr/app/

WORKDIR /usr/app

RUN mvn package

EXPOSE 8086
ENTRYPOINT ["java", "-jar", "exchangeRate.jar"]