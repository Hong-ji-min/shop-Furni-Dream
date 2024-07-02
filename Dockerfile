FROM amazoncorretto:17

LABEL maintainer="jmh907<jmh907@naver.com>"

ARG JAR_FILE_PATH=/furnidream/build/libs/*.jar

COPY ${JAR_FILE_PATH} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]