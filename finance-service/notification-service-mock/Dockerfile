FROM java:8-jre
MAINTAINER Oleksandr Serohin <aleks.seregin@gmail.com>

ADD ./target/notification-service-mock.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/notification-service-mock.jar"]

EXPOSE 6000