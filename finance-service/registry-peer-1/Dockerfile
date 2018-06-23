FROM java:8-jre
MAINTAINER Oleksandr Serohin <aleks.seregin@gmail.com>

ADD ./target/registry-peer-1.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registry-peer-1.jar"]

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8761/registry/health || exit 1

EXPOSE 8761