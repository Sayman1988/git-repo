FROM java:8-jre
MAINTAINER Oleksandr Serohin <aleks.seregin@gmail.com>

ADD ./target/finance-service-mock.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/finance-service-mock.jar"]

EXPOSE 5050