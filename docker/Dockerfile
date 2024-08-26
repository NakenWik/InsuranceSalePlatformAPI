FROM openjdk:11.0.15-jre-buster

RUN groupadd appgroup --gid 211000 && \
    useradd appuser --uid 211000 --gid 211000

WORKDIR /app

#COPY --from=builder /app/target/*.jar /app/
COPY ./target/*.jar /app/

RUN cd /app && \
    echo *.jar > version && \
    mv *.jar ap.jar && \
    chmod +x /app/ap.jar

RUN chown -R appuser:appgroup /app

USER appuser

ENTRYPOINT ["java", "-XX:MaxMetaspaceSize=128m", "-Xss1m", "-jar", "/app/ap.jar"]
