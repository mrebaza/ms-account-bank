# IMAGEN MODELO
FROM eclipse-temurin:21.0.3_9-jdk
LABEL authors="mrebazaa"

# INFORMAR EL PUERTO DONDE SE EJECUTA EL CONTENEDOR
EXPOSE 8082
# DEFINIR EL DIRECTORIO RAIZ
WORKDIR /root

# COPIAR Y PEGAR  ARCHIVOS DENTRO DEL CONTENER
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

# DESCARGAR LAS DEPENDENCIAS
RUN ./mvnw dependency:go-offline

# COPIAR EL CODIGO FUENTE
COPY ./src /root/src

# CONTRUIR NUESTRA LA APLICACION
RUN ./mvnw clean install -DskipTests

# LEVANTAR LA APLICACION AL INICAR EL CONTENDOR
ENTRYPOINT ["java", "-jar","/root/target/rest-0.0.1-SNAPSHOT.jar"]

# comando para crear la imagen
# docker build -t "ms-account-banks"