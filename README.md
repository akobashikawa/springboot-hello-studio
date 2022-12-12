# springboot-hello-studio

Estudiando spring boot: Hello World de varias maneras

## Instalación
- Clonar el repositorio
- mvn clean install
- java -jar target/hello-world-0.0.1-SNAPSHOT.jar
- http://localhost:8080

## Notas
- Un controller es un adaptador entre la web y el core
- Un controller usa services
- Un service se divide en service interface y service implementation
- La service interface es genérica y usa entities
- La service implementation es particular y usa repositories
- Un repository es un adaptador a una persitencia
- Un repository usa entities
