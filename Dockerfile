FROM openjdk:17
EXPOSE 9090
ADD target/todo.0.0.1.jar todo.0.0.1.jar
ENTRYPOINT ["java","-jar","/todo.0.0.1.jar"]