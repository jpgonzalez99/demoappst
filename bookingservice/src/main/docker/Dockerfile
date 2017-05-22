FROM frolvlad/alpine-oraclejdk8:slim 
VOLUME /tmp 
COPY *.jar app.jar 
RUN sh -c 'touch /app.jar' 
ENV SERVER.PORT ${PORT0:-8080}
#EXPOSE ${SERVER.PORT}
#EXPOSE ${SERVER.PORT} 
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#ENTRYPOINT ["sh","-c","-Djava.security.egd=file:/dev/./urandom -Dserver.port=$PORT0","-jar","/app.jar"]
ENTRYPOINT ["sh","-c","java -Djava.security.egd=file:/dev/./urandom -Dserver.port=$PORT0 -jar /app.jar"]

