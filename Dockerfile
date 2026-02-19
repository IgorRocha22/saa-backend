# Etapa 1: Build da aplicação usando o Gradle
FROM eclipse-temurin:21-jdk-jammy AS build
WORKDIR /app

# Copia os arquivos de configuração do Gradle para aproveitar o cache de camadas
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# Dá permissão de execução ao gradlew
RUN chmod +x gradlew

# Baixa as dependências (ajuda a acelerar builds futuros)
RUN ./gradlew dependencies --no-daemon

# Copia o código fonte e gera o arquivo .jar
COPY src src
RUN ./gradlew bootJar --no-daemon

# Etapa 2: Execução da aplicação (Imagem leve)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copia apenas o jar gerado na etapa de build
COPY --from=build /app/build/libs/*.jar app.jar

# Define a porta padrão (o Render/Railway sobrescreve isso automaticamente)
ENV PORT=8080
EXPOSE 8080

# Executa a aplicação passando as variáveis de ambiente para a JVM
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]