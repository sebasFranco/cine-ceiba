FROM OPENJDK:11
VOLUME /tmp
EXPOSE 8082
ADD ./target/servicio-adn.jar servicio-adn.jar
ENTRYPOINT ["java","-jar","/servicio-adn.jar"]