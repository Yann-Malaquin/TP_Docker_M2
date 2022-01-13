#### image d'un jdk8 sous alpine
FROM openjdk:8-jdk-alpine as build

# Working directory au sein de l'image
WORKDIR /app

# Copie du maven executable vers l'image
COPY mvnw .
COPY .mvn .mvn

# Copie du fichier pom.xml
COPY pom.xml .

# Build de toutes les dépendances
# Cette étape permettra de mettre les dépendances en cache, sauf si le pom.xml a changé
RUN ./mvnw dependency:go-offline -B

# Copie du projet
COPY src src

# Package de l'application
RUN ./mvnw package -DskipTests && \
    mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Lancement du serveur springboot
CMD ./mvnw spring-boot:run
