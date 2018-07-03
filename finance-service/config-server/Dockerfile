FROM java:8-jre
MAINTAINER Oleksandr Serohin <aleks.seregin@gmail.com>

ADD ./target/config-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config-server.jar"]

EXPOSE 8080