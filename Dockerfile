FROM alpine:latest

RUN apk --no-cache add openjdk17-jdk

ADD build/libs/enter-the-zone-0.1.0-POC.jar app.jar
EXPOSE 8080
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]


FROM postgres
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB world
