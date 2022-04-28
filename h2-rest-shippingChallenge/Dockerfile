FROM openjdk:11-jdk
ARG JAR_FILE=target/h2-rest-shippingChallenge-1.0.jar
ADD ${JAR_FILE}  h2-rest-shippingchallenge.jar
ENTRYPOINT ["java","-jar","h2-rest-shippingchallenge.jar"]

