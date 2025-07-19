# 1. Službena Java 17 slika
FROM openjdk:17-jdk-alpine

# 2. Postavi radni direktorij
WORKDIR /app

# 3. Kopiraj izgrađeni JAR u kontejner
COPY target/knjznica-0.0.1-SNAPSHOT.jar app.jar

# 4. Pokreni aplikaciju
ENTRYPOINT ["java", "-jar", "app.jar"]