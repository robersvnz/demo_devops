# Usar una imagen base más liviana
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR de tu proyecto al contenedor
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

# Exponer el puerto en el que la app escuchará
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "demo.jar"]
