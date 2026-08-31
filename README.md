# Calidad Pedidos

Proyecto académico Java para realizar análisis estático de código con SonarQube.

## Requisitos

- Java 17 o superior
- Maven 3.9 o superior
- SonarQube y SonarScanner, o Maven con el plugin de Sonar configurado

## Ejecutar pruebas y generar cobertura

```bash
mvn clean test
```

## Ejecutar la aplicación

```bash
mvn package
java -cp target/classes ar.edu.calidadpedidos.Main
```

## Analizar con SonarQube

Con SonarQube iniciado y el token correspondiente:

```bash
mvn clean verify sonar:sonar \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=TU_TOKEN
```
