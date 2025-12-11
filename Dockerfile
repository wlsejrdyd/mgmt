FROM eclipse-temurin:17-jre-alpine

# 보안: non-root 유저
RUN addgroup -S app && adduser -S app -G app

WORKDIR /app

# JAR 복사 (빌드 후 생성되는 경로)
COPY build/libs/*.jar app.jar

# 보안: 소유권 변경
RUN chown -R app:app /app
USER app

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
