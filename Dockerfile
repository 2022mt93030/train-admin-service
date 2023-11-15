FROM openjdk:17.0.9-jre-stretch
WORKDIR /opt/app
RUN chmod +x /opt/app
ADD build/libs/train-admin-service*.jar  /opt/app/train-admin-service.jar
ADD .devops/start.sh  /opt/app/start.sh
EXPOSE 8091
ENTRYPOINT ["sh","/opt/app/start.sh"]