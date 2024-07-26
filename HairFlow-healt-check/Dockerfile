# Usa un'immagine base di Maven per costruire il progetto
FROM maven:3.8.4-openjdk-17 AS build

# Imposta la directory di lavoro all'interno del container
WORKDIR /app

# Copia il file pom.xml e src nella directory di lavoro
COPY pom.xml .
COPY src ./src

# Costruisci il progetto
RUN mvn clean package -DskipTests

# Usa un'immagine più leggera per eseguire l'applicazione
FROM openjdk:17-jdk-slim

# Crea una directory per l'applicazione
WORKDIR /app

# Copia il file JAR dal container di build
COPY --from=build /app/target/HairFlow-healt-check-0.0.1.jar /app/HairFlow-healt-check.jar

# Espone la porta su cui l'applicazione gira (modifica se necessario)
EXPOSE 8761

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "HairFlow-healt-check.jar"]