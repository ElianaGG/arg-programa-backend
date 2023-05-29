FROM amazoncorretto:8-alpine-jdk
COPY target/arg-programa-backend-0.0.1-SNAPSHOT.jar arg-programa.jar
ENTRYPOINT ["java","-jar","/arg-programa.jar"]
