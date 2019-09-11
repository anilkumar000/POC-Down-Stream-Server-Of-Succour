FROM openjdk:11

WORKDIR /user/src

ADD ./target/downstream-server-0.0.1-SNAPSHOT.jar /user/src/downstream-server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","downstream-server-0.0.1-SNAPSHOT.jar"]
