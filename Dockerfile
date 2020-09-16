FROM adoptopenjdk/openjdk11
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/spring-docker-sgcpf.jar
WORKDIR /app
ENTRYPOINT java -jar spring-docker-sgcpf.jar