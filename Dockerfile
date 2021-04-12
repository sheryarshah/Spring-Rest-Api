# Compile java files in this container
FROM openjdk:15-alpine AS builder
RUN apk add maven
COPY . /usr/src/noyo/Server
WORKDIR /usr/src/noyo/Server
RUN mvn clean package

# Copy the jar into final image
FROM openjdk:15-alpine
WORKDIR /usr/src/noyo/
COPY ./bin/* ./
RUN dos2unix ./startserver.sh
COPY --from=builder /usr/src/noyo/Server/target/Noyo-1.0.jar ./noyo.jar