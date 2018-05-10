FROM java:8-jre
MAINTAINER Oleksandr Serohin <aleks.seregin@gmail.com>

ADD ./target/config-server.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config-server.jar"]

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8888/config-server/health || exit 1

EXPOSE 8888