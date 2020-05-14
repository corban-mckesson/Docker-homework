FROM java:8
ADD ./target/hello-name-0.0.3.jar hello-name.jar
ADD ./src/main/resources/jars/h2-1.4.199.jar h2.jar
EXPOSE 8080 8082
CMD java -jar hello-name.jar
CMD java -jar h2.jar